#数据库表中的字段信息
class FieldInfo():
	"""D模型中的字段信息"""
	def __init__(self, eng_nm, chn_nm, dict_no, db_type, length, is_key, is_nullable):
		"""字段信息初始化方法"""
		#字段英文名
		self.eng_nm = eng_nm
		#字段中文名
		self.chn_nm = chn_nm
		#字段数据字典编号
		self.dict_no = dict_no
		#数据库字段类型
		self.db_type = db_type
		#字段长度
		self.length = length
		#是否为主键
		self.is_key = is_key
		#能否为空
		self.is_nullable = is_nullable
		#日期类型
		#self.date_type = date_type
		
