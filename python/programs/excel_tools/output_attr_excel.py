#将D模型信息写入到实体属性excel中
import logging
import openpyxl
import abc

from field_info import FieldInfo
from table_info import TableInfo

logging.basicConfig(level=logging.DEBUG, format=' %(asctime)s - %(levelname)s - %(message)s')

class CreateAttrExcel():
    """根据表、字段信息创建实体属性excel"""

    def __init__(self, parm_info, attr_model_excel, date, output_excel_path):
        """初始化方法
        参数：
        parm_info: 根据excel读取的参数数据库表和字段信息对象
        attr_model_excel: 实体属性模板excel文件路径
        date: 上线日期
        output_excel_path: 输出的文件路径
       """
        self.parm_info = parm_info
        self.attr_model_excel = attr_model_excel
        self.date = date
        self.output_excel_path = output_excel_path
    
    def write_attr_excel(self):
        """创建实体属性文件"""
        wb = openpyxl.load_workbook(self.attr_model_excel)
        self.write_parm_info_sheet(wb['参数信息表'], self.parm_info)
        self.write_attr_info_sheet(wb['实体属性'], self.parm_info)
        self.write_txn_info_sheet(wb['交易界面'], self.parm_info)
        self.write_page_field_sheet(wb['页面栏位'], self.parm_info)
    
        output_excel_nm = '参数设计属性信息_' + self.date + '_' + self.parm_info.parm_nm + '.xlsx'
        logging.info('输出文件路径: ' + self.output_excel_path + output_excel_nm)
        wb.save(self.output_excel_path + output_excel_nm)
    
    @abc.abstractmethod
    def write_parm_info_sheet(self, sheet, parm_info):
        """写入实体属性excel "参数信息表"sheet的内容
        参数：
            sheet: "参数信息"sheet
            parm_info: 参数信息
        """
        pass
        
    
    @abc.abstractmethod
    def write_attr_info_sheet(self, attr_sheet, parm_info):
        """写入实体属性excel "实体属性" sheet的内容
        参数：
            sheet: "实体属性" sheet
            parm_info: 根据excel读取的参数数据库表和字段信息对象
        """
        pass
    
    @abc.abstractmethod
    def write_txn_info_sheet(self, txn_sheet, parm_info):
        """写入"交易信息" SHEET
        参数：
            txn_sheet: 交易信息 sheet
            parm_info: 根据excel读取的参数数据库表和字段信息对象
        """
        pass

    @abc.abstractmethod
    def write_page_field_sheet(self, page_sheet, parm_info):
        """写入 "页面栏位" SHEET
        参数：
            page_sheet: 页面栏位 sheet
            parm_info: 根据excel读取的参数数据库表和字段信息对象
        """
        pass
            

    def getWhetherChnChar(self, boolVar):
        if boolVar:
            return '是'
        else:
            return '否'
