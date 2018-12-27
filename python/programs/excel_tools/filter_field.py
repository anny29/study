import openpyxl
import logging

excel_path = "C:\\Users\\Anny\\Desktop\\table_inf.xlsx"
wb = openpyxl.load_workbook(excel_path)
sheet = wb['Sheet1']
filter_list = []
for row in range(1, 31):
    filter_table = sheet['D' + str(row)].value
    filter_list.append(filter_table)

for row in range(1, 83):
    table = sheet['E' + str(row)].value
    if filter_list.count(table) > 0:
        continue
    else:
        sheet['F' + str(row)] = '1'

wb.save(excel_path)