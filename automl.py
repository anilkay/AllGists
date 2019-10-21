autocls=autosklearn.classification.AutoSklearnClassifier() #Tanımlama  aşaması

autocls.fit(x_train,y_train) #eğitim aşaması

eniyiler=autocls.show_models() #en iyi algoritma ve parametleri bu değişkende göreceğiz.

ypred=autocls.predict(x_test) #en iyi model ile predictionu'da yapabiliyouz. 