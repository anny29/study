from output_attr_excel import CreateAttrExcel

class CreateAttrExeclImpl(CreateAttrExcel):
    """创建实体属性excel实现类"""
    
    def __init__(self, table_info, attr_model_excel, parm_no, parm_nm, date, output_excel_path):
        super().__init__(table_info, attr_model_excel, parm_no, parm_nm, date, output_excel_path)
    
    def write_parm_info_sheet(self, sheet, table_chn_nm, table_eng_nm, parm_no):
        sheet['B5'] = table_eng_nm
        sheet['C5'] = table_chn_nm
        sheet['I5'] = parm_no
        sheet['N5'] = parm_no
    
    def write_attr_info_sheet(self, attr_sheet, table_info):
        for field_index in range(0, len(table_info.fields_info)):
            row_num = field_index + 5
            attr_sheet['B' + str(row_num)] = table_info.table_eng_nm
            attr_sheet['C' + str(row_num)] = table_info.fields_info[field_index].eng_nm
            attr_sheet['J' + str(row_num)] = table_info.fields_info[field_index].chn_nm
            attr_sheet['L' + str(row_num)] = table_info.fields_info[field_index].dict_no
            attr_sheet['M' + str(row_num)] = table_info.fields_info[field_index].db_type
            attr_sheet['N' + str(row_num)] = super().getWhetherChnChar(table_info.fields_info[field_index].is_key)  
            attr_sheet['O' + str(row_num)] = '否'   
            attr_sheet['P' + str(row_num)] = super().getWhetherChnChar(table_info.fields_info[field_index].is_nullable)
            if 'DATE' == table_info.fields_info[field_index].db_type:
                attr_sheet['S' + str(row_num)] = '其他日期'
            else:
                attr_sheet['S' + str(row_num)] = '非日期字段'
    
    def write_txn_info_sheet(self, txn_sheet, parm_no, parm_nm):
        """写入"交易信息" SHEET
        参数：
            txn_sheet: 交易信息 sheet
            parm_no: 参数编号
            parm_nm: 参数名称
        """
        txn_sheet['C5'] = parm_nm
        txn_sheet['G5'] = parm_no
    
    def write_page_field_sheet(self, page_sheet, parm_no, parm_nm, table_info):
        """写入 "页面栏位" SHEET
        参数：
            page_sheet: 页面栏位 sheet
            parm_no: 参数编号
            parm_nm: 参数名称
            table_info: 数据库D模型信息
        """
        for field_index in range(0, len(table_info.fields_info)):
            row_num = field_index + 5
            page_sheet['B' + str(row_num)] = parm_nm
            page_sheet['D' + str(row_num)] = table_info.fields_info[field_index].chn_nm
            page_sheet['F' + str(row_num)] = parm_no
            page_sheet['G' + str(row_num)] = table_info.table_eng_nm.upper() + '-' + \
            table_info.fields_info[field_index].eng_nm.upper()
            page_sheet['H' + str(row_num)] = table_info.fields_info[field_index].chn_nm
            page_sheet['I' + str(row_num)] = table_info.fields_info[field_index].eng_nm
            page_sheet['J' + str(row_num)] = table_info.fields_info[field_index].db_type
            page_sheet['K' + str(row_num)] = table_info.fields_info[field_index].length
            page_sheet['M' + str(row_num)] = super().getWhetherChnChar(table_info.fields_info[field_index].is_key)
            page_sheet['N' + str(row_num)] = super().getWhetherChnChar(table_info.fields_info[field_index].is_nullable)