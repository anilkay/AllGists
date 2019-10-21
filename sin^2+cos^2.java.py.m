function out=sin2cos2(degree)
controle=0;
not=0;
while degree<100 

degree=degree+0.01;

%disp(out);
if degree~=0
    controle=controle+1;
else
    not=not+1;
end
%Always return 1 or something like that. İt is very interesting.
end
disp(controle);
disp(not);
out=sin(degree)^2+cos(degree)^2;
##############################################################################################
##############################################################################################
##############################################################################################
##############################################################################################
while i<100:
    b=math.sin(i)*math.sin(i)+math.cos(i)*math.cos(i)
    i=i+1
    print(b)
 #############################################################################################
 #############################################################################################
 #############################################################################################
 #############################################################################################
 private void displaysin2cos2(double degree){
        for(double i=0;i<100;i+=0.01) {
            //Precision problemi var ancak hiç te fena çalışmıyor.
            double dub = Math.pow(Math.sin(degree), 2) + Math.pow(Math.cos(degree), 2);
            System.out.println("deneyelim de deneyelim: " + dub);
        }
    }     