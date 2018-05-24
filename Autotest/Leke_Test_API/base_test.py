
# coding=utf8
import urllib, urllib2, cookielib, json

config = {
    "domain": "http://121.199.5.116:8080"
}

headers = {"Content-Type": "application/json"}




result = {}

# filename = 'cookie.txt'
# 声明一个MozillaCookieJar对象实例来保存cookie，之后写入文件
# cookie = cookielib.MozillaCookieJar(filename)
cookie = cookielib.CookieJar()

opener = urllib2.build_opener(urllib2.HTTPCookieProcessor(cookie))


def post(key, url, params):
    try:
        url = '%s%s' % (config["domain"], url)
        print url

        request = urllib2.Request(url, urllib.urlencode(params),headers=headers)
       # request.add_header('content-TYPE', 'application/json')
        response = opener.open(request)
        # response = urllib2.urlopen(request)

        jsonStr = response.read()

        # cookie.save(ignore_discard=True, ignore_expires=True)
        print '序号：%s\n接口地址：%s\n返回值：%s' % (key, url, jsonStr)
        # json序列化成对象
        jsonObj = json.loads(jsonStr)
        result[key] = jsonObj
        return True
    except Exception, e:
        print e
        return False

