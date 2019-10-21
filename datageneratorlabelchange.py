from keras.preprocessing.image import ImageDataGenerator
datagen = ImageDataGenerator(
    featurewise_center=True,
    featurewise_std_normalization=True,
    rotation_range=20,
    width_shift_range=0.2,
    height_shift_range=0.2,
    horizontal_flip=True)

image_generator = datagen.flow_from_directory(
        imagepath,
        target_size=(150, 150),
        batch_size=32
       ) #Data is loaded with wrong labels.
       
labels=data["label"]
from sklearn import preprocessing
le = preprocessing.LabelEncoder()
labels2=le.fit_transform(labels) #true labels is loaded.
image_generator.classes=labels2 #Change all labels
image_generator.class_mode="binary" #Change class modes if wrong default is categorical.