function sonuc=listsquares(A,b)
%Ax=b without solution we should use list square method.
transA=transpose(A);
newA=transA*A;
newb=transA*b;
x=mldivide(newA,newb);
sonuc=x; %List square method. 
