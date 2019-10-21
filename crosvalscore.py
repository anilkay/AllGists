from sklearn.model_selection import cross_val_score
accuries = cross_val_score(estimator=knn,X=x_train, y = y_train,cv=10)