# coding=utf-8

from selenium import webdriver

path = '/Users/yuhao/work_data/software_for_mac/WebDriver/chromedriver'

driver = webdriver.Chrome(path)
driver.get('http://www.baidu.com')
print driver.title


