import pg8000
conn = pg8000.connect(user="username", password="password",database="dbname")
conn.autocommit = True
cur.execute("Create Table t1(id serial,f1 text,f2 int)")
cur.execute("Select * from t1")
result=cur.fetchall()
