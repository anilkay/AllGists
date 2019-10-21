sehir=imread('/Users/anilkaynar/Desktop/sehir.jpeg');
sehir=imresize(sehir,[500,500]); %resize the image.
binari= sehir(:,:,2)>120; %Binary image is work just fine.

key=rand(500,500);
key2=key>=0.3;
key2=double(key2); %key creation is done.

ciphertext=binari*((key2)); %create ciphertext

inversekey=inv((key2)); %Decryption start.
plainimage=ciphertext*inversekey; 
imshowpair(ciphertext,plainimage,'montage');

