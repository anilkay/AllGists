#İmports
import numpy as np
from sklearn.linear_model import LogisticRegressionCV
from keras.models import Sequential
from keras.layers.core import Dense, Activation
from keras.utils import np_utils
import pandas as pd
#And Gate
vekapisi=Sequential()
vekapisi.add(Dense(2,init='uniform',activation='relu',input_dim=2))
vekapisi.add(Dense(4,init='uniform',activation='relu'))
vekapisi.add(Dense(1,init='uniform',activation='sigmoid'))
vekapisi.compile(optimizer = 'adam', loss =  'binary_crossentropy' , metrics = ['accuracy'] )
import numpy as np
yses=np.asarray([0,0,0,1])
tur=np.array([[0,0],[0,1],[1,0],[1,1]])
vekapisi.fit(tur,yses,epochs=2040)
seylermi=vekapisi.predict(tur)>0.5
print(str(seylermi)) 
########################################
#Or Gate
veyakapisi=Sequential()
veyakapisi.add(Dense(2,init='uniform',activation='relu',input_dim=2))
veyakapisi.add(Dense(4,init='uniform',activation='relu'))
veyakapisi.add(Dense(1,init='uniform',activation='sigmoid'))
veyakapisi.compile(optimizer = 'adam', loss =  'binary_crossentropy' , metrics = ['accuracy'] )
import numpy as np
yses=np.asarray([0,1,1,1])
tur=np.array([[0,0],[0,1],[1,0],[1,1]])
veyakapisi.fit(tur,yses,epochs=2040,verbose=0)
seylermi=veyakapisi.predict(tur)>0.5
print("orkapisi")
print(str(seylermi)) 
#######################################################
#XOR Gate
xorkapisi=Sequential()
xorkapisi.add(Dense(2,init='uniform',activation='relu',input_dim=2))
xorkapisi.add(Dense(4,init='uniform',activation='relu'))
xorkapisi.add(Dense(1,init='uniform',activation='sigmoid'))
xorkapisi.compile(optimizer = 'adam', loss =  'binary_crossentropy' , metrics = ['accuracy'] )
import numpy as np
yses=np.asarray([0,1,1,0])
tur=np.array([[0,0],[0,1],[1,0],[1,1]])
xorkapisi.fit(tur,yses,epochs=2040,verbose=0)
seylermi=xorkapisi.predict(tur)>0.5
print("exorkapisi")
print(str(seylermi))
