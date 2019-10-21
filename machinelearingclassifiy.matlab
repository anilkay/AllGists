load fisheriris
X = meas;
Y = species;
%KNN
Mdl = fitcknn(X,Y,'NumNeighbors',5,'Standardize',1); 
Mdl.predict([1,1,1,1]); %say it setosho.
Mdl.predict([10,5,44,66]); %Virginica
Mdl.predict([0,0,0,0]);  %Versicolor 
%SVM
%svm=fitcsvm(X,Y); You cannot train Svm for more than 2 class
%svm is for binary classification. 
%Naive Bayes
naive=fitcnb(X,Y);
naive.predict([1,1,1,1]); %versicolor
naive.predict([10,5,44,66]); %Virginica
naive.predict([0,0,0,0]);   %Versicolor. İt is interesting.

%Decision Tree
decisionTree=fitctree(X,Y)
decisionTree.predict([1,1,1,1]); %Setosa
decisionTree.predict([10,5,44,66]); %Virginica
decisionTree.predict([0,0,0,0]); %Setosa
%view(decisionTree,'Mode','graph'); %Decision Tree Visualizer.
dt2 = prune(decisionTree); %Nothing change in pruning.
%view(dt2,'Mode','graph');
%Random Forest
randomforest=TreeBagger(10,X,Y)
randomforest.predict([1,1,1,1]) %setosa
randomforest.predict([10,5,44,66]) %virginica
randomforest.predict([0,0,0,0]) %setosa