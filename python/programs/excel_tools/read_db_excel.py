#读取数据库D模型信息
import openpyxl
import logging

from table_info import TableInfo
from field_info import FieldInfo

logging.basicConfig(level=logging.DEBUG, format=' %(asctime)s - %(levelname)s - %(message)s')

def read_db_table_info(db_table_excel):
    """从数据库表中读取表名、字段等信息
    参数：
        db_table_excel: 数据库D模型excel路径
    返回值：
        TableInfo: 据D模型excel读取的数据库表和字段信息对象
    """
    wb = openpyxl.load_workbook(db_table_excel)
    sheet = wb['表结构']
    filed_list = []
    for row in range(2, sheet.max_row + 1):
        field_eng_nm = sheet['I' + str(row)].value
        if None == field_eng_nm:
            continue
        field_chn_nm = sheet['J' + str(row)].value
        filed_dict_no = sheet['K' + str(row)].value
        filed_db_type = sheet['L' + str(row)].value
        filed_length = sheet['M' + str(row)].value
        
        if 'P' == sheet['O' + str(row)].value:
            filed_is_key = True
        else:
            filed_is_key = False
        
        if '是' == sheet['R' + str(row)].value:
            filed_is_nullable = True
        else:
            filed_is_nullable = False
        
        field_info = FieldInfo(field_eng_nm, field_chn_nm, filed_dict_no, filed_db_type, filed_length, filed_is_key, filed_is_nullable)
        filed_list.append(field_info)
    
    table_eng_nm = sheet['G2'].value
    table_chn_nm = sheet['H2'].value
    table_info = TableInfo(table_eng_nm, table_chn_nm, filed_list)
    logging.info('数据库表名：' + table_info.table_eng_nm + " " + table_info.table_chn_nm)
    logging.info('字段个数：' + str(len(table_info.fields_info)))
    return table_info