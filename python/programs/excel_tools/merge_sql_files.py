#合并sql文件
import os
import logging

logging.basicConfig(level=logging.DEBUG, format=' %(asctime)s - %(levelname)s - %(message)s')

def merge_sql_files(file_path, output_file_nm):
    """将指定目录下的sql脚本合并为一个
    参数：
        file_path: sql脚本目录
        output_file_nm: 输出文件
    """

    output_file = open(output_file_nm, 'w', encoding='utf8')
    file_count = 0
    for file_name in os.listdir(file_path):
        logging.info("读取文件：" + file_name)
        line_spes = ['\n', '\n']
        with open(os.path.join(file_path, file_name), encoding='utf8') as sql_file:            
            output_file.writelines(line_spes)
            output_file.writelines(sql_file.readlines())
        file_count += 1
    output_file.close()
    logging.info("文件合并完毕，共合并了" + str(file_count) + "个文件")

sql_file_path = 'C:\\Users\\Anny\\Desktop\\参数管理数据版本\\201810\\业务审批参数组件初始化20180930'
output_file_nm = 'C:\\Users\\Anny\\Desktop\\参数管理数据版本\\201810\\ywsp_20181027_0930.sql'
merge_sql_files(sql_file_path, output_file_nm)

