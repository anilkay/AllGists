import face_recognition
from skimage import io
image = face_recognition.load_image_file("deneme.jpg")
face_locations = face_recognition.face_locations(image)
print(face_locations)
face_locations=face_locations[0]
croppedr=image[face_locations[0]:face_locations[2],face_locations[3]:face_locations[1]]
io.imshow(cropped) #face