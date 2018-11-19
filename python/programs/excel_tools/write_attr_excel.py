#将D模型信息写入到实体属性excel中
import logging
import openpyxl

from field_info import FieldInfo
from table_info import TableInfo

logging.basicConfig(level=logging.DEBUG, format=' %(asctime)s - %(levelname)s - %(message)s')

def write_attr_excel(table_info, attr_model_excel, parm_no, parm_nm, date, output_excel_path):
    """根据数据库表信息、参数编号和参数名称创建实体属性excel
    参数：
        table_info: 根据D模型excel读取的数据库表和字段信息对象
        attr_model_excel: 实体属性模板excel文件路径
        parm_no: 参数编号
        parm_nm: 参数名称
        date: 上线日期
        output_excel_path: 输出的文件路径
    """
    wb = openpyxl.load_workbook(attr_model_excel)
    write_parm_info_sheet(wb['参数信息表'], table_info.table_chn_nm, table_info.table_eng_nm, parm_no)
    write_attr_info_sheet(wb['实体属性'], table_info)
    write_txn_info_sheet(wb['交易界面'], parm_no, parm_nm)
    write_page_field_sheet(wb['页面栏位'], parm_no, parm_nm, table_info)
    
    output_excel_nm = '参数设计属性信息_' + date + '_' + parm_nm + '.xlsx'
    logging.info('输出文件路径: ' + output_excel_path + output_excel_nm)
    wb.save(output_excel_path + output_excel_nm)
    

def write_parm_info_sheet(sheet, table_chn_nm, table_eng_nm, parm_no):
    """写入实体属性excel "参数信息表"sheet的内容
    参数：
        sheet: "参数信息"sheet
        table_chn_nm：表中文名
        table_eng_nm: 表英文名
        parm_no: 参数编号
    """
    sheet['A3'] = '新增参数新增'
    sheet['B3'] = table_chn_nm
    sheet['C3'] = table_eng_nm
    sheet['D3'] = parm_no
    sheet['E3'] = parm_no

def write_attr_info_sheet(attr_sheet, table_info):
    """写入实体属性excel "实体属性" sheet的内容
     参数：
        sheet: "实体属性" sheet
        table_info: 根据D模型excel读取的数据库表和字段信息对象
    """
    for field_index in range(0, len(table_info.fields_info)):
        row_num = field_index + 3
        attr_sheet['A' + str(row_num)] = '新参数新增'
        attr_sheet['B' + str(row_num)] = table_info.table_eng_nm
        attr_sheet['C' + str(row_num)] = table_info.fields_info[field_index].eng_nm
        attr_sheet['E' + str(row_num)] = table_info.fields_info[field_index].chn_nm
        attr_sheet['G' + str(row_num)] = table_info.fields_info[field_index].dict_no
        attr_sheet['H' + str(row_num)] = table_info.fields_info[field_index].db_type
        attr_sheet['I' + str(row_num)] = getWhetherChnChar(table_info.fields_info[field_index].is_key)  
        attr_sheet['J' + str(row_num)] = '否'   
        attr_sheet['K' + str(row_num)] = getWhetherChnChar(table_info.fields_info[field_index].is_nullable)
        if 'DATE' == table_info.fields_info[field_index].db_type:
            attr_sheet['N' + str(row_num)] = '其他日期'
        else:
            attr_sheet['N' + str(row_num)] = '非日期字段'

def write_txn_info_sheet(txn_sheet, parm_no, parm_nm):
    """写入"交易信息" SHEET
    参数：
        txn_sheet: 交易信息 sheet
        parm_no: 参数编号
        parm_nm: 参数名称
    """
    txn_sheet['C3'] = parm_nm
    txn_sheet['D3'] = parm_no

def write_page_field_sheet(page_sheet, parm_no, parm_nm, table_info):
    """写入 "页面栏位" SHEET
    参数：
        page_sheet: 页面栏位 sheet
        parm_no: 参数编号
        parm_nm: 参数名称
        table_info: 数据库D模型信息
    """
    for field_index in range(0, len(table_info.fields_info)):
        row_num = field_index + 3
        page_sheet['A' + str(row_num)] = '新增'
        page_sheet['B' + str(row_num)] = parm_nm
        page_sheet['D' + str(row_num)] = table_info.fields_info[field_index].chn_nm
        page_sheet['F' + str(row_num)] = parm_no
        page_sheet['G' + str(row_num)] = table_info.table_eng_nm.upper() + '-' + \
         table_info.fields_info[field_index].eng_nm.upper()
        page_sheet['H' + str(row_num)] = table_info.fields_info[field_index].chn_nm
        page_sheet['I' + str(row_num)] = table_info.fields_info[field_index].eng_nm
        page_sheet['J' + str(row_num)] = table_info.fields_info[field_index].db_type
        page_sheet['K' + str(row_num)] = table_info.fields_info[field_index].length
        page_sheet['M' + str(row_num)] = getWhetherChnChar(table_info.fields_info[field_index].is_key)
        page_sheet['N' + str(row_num)] = getWhetherChnChar(table_info.fields_info[field_index].is_nullable)
        

def getWhetherChnChar(boolVar):
    if boolVar:
        return '是'
    else:
        return '否'