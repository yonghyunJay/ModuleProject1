import requests
from bs4 import BeautifulSoup

search = input("검색어를 입력하세요 : ")
baseurl = f"https://search.naver.com/search.naver?&where=news&query={search}&sm=tab_pge&sort=0&photo=0&field=0&reporter_article=&pd=0&ds=&de=&docid=&nso=so:r,p:all,a:all&mynews=0&cluster_rank=59&start=1&refresh_start=0"
url = baseurl + search
html = requests.get(url).text
data = BeautifulSoup(html, 'html.parser')
li = data.select('ul.type01 > li')
setdata = data.find_all(class_ = '_sp_each_title')
passge = data.find_all(class_ = 'sh_blog_passage')
Thumnail = data.find_all('.sp_thmb thmb80' > 'img')
n = 1
for i in setdata:
    print(i['title'])
    print(i['href'])
    print("%d번째 자료 출력" % n)
    n += 1
for i in li:
    img = i.select_one('img')
    src = img['src']
    print(src)
