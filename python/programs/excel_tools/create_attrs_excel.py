#根据参数D模型生成参数实体属性EXCEL
from read_db_excel import read_db_table_info
from write_attr_excel import write_attr_excel
from output_attr_excel_impl import CreateAttrExeclImpl
from parm_info import ParmInfo

<<<<<<< Updated upstream
db_table_excel = 'C:\\Users\\Anny\\Desktop\\3.2期\\实体属性\\db_excel\\TBCRPAI0.xlsx'
#attr_model_excel = 'C:\\excel_data\\ATTR_MODEL.xlsx'
attr_model_excel = 'C:\\Users\\Anny\\Desktop\\3.2期\\实体属性\\模板\\输出模板.xlsx'
output_excel_path = 'C:\\Users\\Anny\\Desktop\\3.2期\\实体属性\\'
parm_no = 'P-JJK-017'
parm_nm = '借记卡专项账户指定开户机构参数'
date = '20181124'

table_info = read_db_table_info(db_table_excel)

#write_attr_excel(table_info, attr_model_excel, parm_no, parm_nm, date, output_excel_path)
output_excel = CreateAttrExeclImpl(table_info, attr_model_excel, parm_no, parm_nm, date, output_excel_path)
output_excel.write_attr_excel()
=======
cf = configparser.ConfigParser()
cf.read('D:\\工作\\实体属性\\db_excel\\attrs.conf', encoding='utf-8')
db_table_excel = cf.get('info', 'db_excel_path')
attr_model_excel = cf.get('info', 'attr_model_excel')
output_excel_path = cf.get('info', 'output_excel_path')
# parm_no = cf.get('info', 'parm_no')
# parm_nm = cf.get('info', 'parm_name')
date = cf.get('info', 'date')
excel_mode = cf.get('info', 'excel_mode')

parm_infos = read_table_info(db_table_excel, excel_mode)

for parm_info in parm_infos:
    output_excel = CreateAttrExeclImpl(parm_info, attr_model_excel, date, output_excel_path)
    output_excel.write_attr_excel()
>>>>>>> Stashed changes




        


