from output_attr_excel import CreateAttrExcel

class CreateAttrExeclImpl(CreateAttrExcel):
    """创建实体属性excel实现类"""
    
    def __init__(self, parm_info, attr_model_excel, date, output_excel_path):
        super().__init__(parm_info, attr_model_excel, date, output_excel_path)
    
    def write_parm_info_sheet(self, sheet, parm_info):
        row_num = 5
        for table_info in parm_info.table_infos:
            sheet['B' + str(row_num)] = table_info.table_eng_nm
            sheet['C' + str(row_num)] = table_info.table_chn_nm
            sheet['I' + str(row_num)] = parm_info.parm_no
            sheet['N' + str(row_num)] = parm_info.parm_no
            row_num += 1
    
    def write_attr_info_sheet(self, attr_sheet, parm_info):
        row_num = 5
        for table_info in parm_info.table_infos:
            for field_info in table_info.fields_info:
                attr_sheet['B' + str(row_num)] = table_info.table_eng_nm
                attr_sheet['C' + str(row_num)] = field_info.eng_nm
                attr_sheet['J' + str(row_num)] = field_info.chn_nm
                attr_sheet['L' + str(row_num)] = field_info.dict_no
                attr_sheet['M' + str(row_num)] = field_info.db_type
                attr_sheet['N' + str(row_num)] = super().getWhetherChnChar(field_info.is_key)  
                attr_sheet['O' + str(row_num)] = '否'   
                attr_sheet['P' + str(row_num)] = super().getWhetherChnChar(field_info.is_nullable)
                if 'DATE' == field_info.db_type:
                    attr_sheet['S' + str(row_num)] = '其他日期'
                else:
                    attr_sheet['S' + str(row_num)] = '非日期字段'
                row_num += 1
    
    def write_txn_info_sheet(self, txn_sheet, parm_info):
        """写入"交易信息" SHEET
        参数：
            txn_sheet: 交易信息 sheet
            parm_no: 参数编号
            parm_nm: 参数名称
        """
        txn_sheet['C5'] = parm_info.parm_nm
        txn_sheet['G5'] = parm_info.parm_no
    
    def write_page_field_sheet(self, page_sheet, parm_info):
        """写入 "页面栏位" SHEET
        参数：
            page_sheet: 页面栏位 sheet
            parm_info: 数据库D模型信息
        """
        row_num = 5
        for table_info in parm_info.table_infos:         
            for field_info in table_info.fields_info:
                page_sheet['B' + str(row_num)] = parm_info.parm_nm
                page_sheet['D' + str(row_num)] = field_info.chn_nm
                page_sheet['F' + str(row_num)] = parm_info.parm_no
                page_sheet['G' + str(row_num)] = table_info.table_eng_nm.upper() + '-' + field_info.eng_nm.upper()
                page_sheet['H' + str(row_num)] = field_info.chn_nm
                page_sheet['I' + str(row_num)] = field_info.eng_nm
                page_sheet['J' + str(row_num)] = field_info.db_type
                page_sheet['K' + str(row_num)] = field_info.length
                page_sheet['M' + str(row_num)] = super().getWhetherChnChar(field_info.is_key)
                page_sheet['N' + str(row_num)] = super().getWhetherChnChar(field_info.is_nullable)
                row_num += 1