soup=BeautifulSoup(sors,"html.parser")
imgs=soup.findAll("img")
for i in imgs:
    src=i["src"] #src ile alınmıştır
    print(src.encode("utf8"))