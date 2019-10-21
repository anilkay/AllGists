from sklearn.preprocessing import LabelEncoder
lb = LabelEncoder()
data = data.apply(lb.fit_transform)