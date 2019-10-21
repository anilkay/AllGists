from sklearn.ensemble import VotingClassifier
from sklearn.ensemble import RandomForestClassifier
from sklearn.svm import LinearSVC
from sklearn.svm import NuSVC
from sklearn.naive_bayes import GaussianNB
knn2=KNeighborsClassifier(n_neighbors=13)
ada2=AdaBoostClassifier(n_estimators=150)
dt2=DecisionTreeClassifier()
linsvc=LinearSVC()
nusvc=NuSVC()
randomforest=RandomForestClassifier(n_estimators=50,random_state=4)
votme=VotingClassifier([('knn',knn2),('decisiontree',dt2),("randomforest",randomforest)
                       ,("LinearSvc",linsvc),("NuSvc",nusvc)
                       ])
votme.fit(x_train,y_train)
ypred=votme.predict(x_test)
cm=confusion_matrix(y_test,ypred)
accscr=accuracy_score(y_test,ypred)
print(cm)
print(accscr) 