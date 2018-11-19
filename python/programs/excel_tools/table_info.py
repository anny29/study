#数据库表信息
class TableInfo():
	"""数据库表类"""
	
	def __init__(self, table_eng_nm, table_chn_nm, fields_info):
		"""数据库表信息初始化方法"""
		#表英文名
		self.table_eng_nm = table_eng_nm
		#表中文名
		self.table_chn_nm = table_chn_nm
		#字段信息
		self.fields_info = fields_info
