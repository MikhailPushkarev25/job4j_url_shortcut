[![Build Status](https://app.travis-ci.com/MikhailPushkarev25/job4j_url_shortcut.svg?branch=master)](https://app.travis-ci.com/MikhailPushkarev25/job4j_url_shortcut)
[![codecov](https://codecov.io/gh/MikhailPushkarev25/job4j_url_shortcut/branch/master/graph/badge.svg?token=SyBdWfKGun)](https://codecov.io/gh/MikhailPushkarev25/job4j_url_shortcut)

Чтобы обеспечить безопасность пользователей, все ссылки на сайте заменяются ссылками на наш сервис.

Сервис работает через REST API.

Требуемый функционал.

1. Регистрация сайта.

Сервисом могут пользоваться разные сайты. Каждому сайту выдается пару пароль и логин.

Чтобы зарегистрировать сайт в систему нужно отправить запроса.

URL

nginx
POST /registration
C телом JSON объекта.

css
{site : "job4j.ru"}
Ответ от сервера.

css
{registration : true/false, login: УНИКАЛЬНЫЙ_КОД, password : УНИКАЛЬНЫЙ_КОД}
Флаг registration указывает, что регистрация выполнена или нет, то есть сайт уже есть в системе.

2. Авторизация.

Авторизацию сделать через JWT. Пользователь отправляет POST запрос с login и password и получает ключ.

Этот ключ отправляет в запросе в блоке HEAD.

http
Authorization: Bearer e25d31c5-db66-4cf2-85d4-8faa8c544ad6


3. Регистрация URL.

Поле того, как пользователь зарегистрировал свой сайт он может отправлять на сайт ссылки и получать преобразованные ссылки.

Пример.

Отправляем URL.

less
https://job4j.ru/profile/exercise/106/task-view/532
Получаем.

text
ZRUfdD2
Ключ ZRUfD2 ассоциирован с URL.

Опишем вызовы.

nginx
POST /convert
C телом JSON объекта.

css
{url: "https://job4j.ru/profile/exercise/106/task-view/532"}
Ответ от сервера.

css
{code: УНИКАЛЬНЫЙ_КОД}
4. Переадресация. Выполняется без авторизации.

Когда сайт отправляет ссылку с кодом в ответ нужно вернуть ассоциированный адрес и статус 302.

Опишем вызовы.

coffeescript
GET /redirect/УНИКАЛЬНЫЙ_КОД
Ответ от сервера в заголовке.

nginx
HTTP CODE - 302 REDIRECT URL
5. Статистика.

В сервисе считается количество вызовов каждого адреса.

Увеличение счетчика нужно сделать в базе данных, а не в Java. В ответе нужно объяснить почему.

По сайту можно получить статистку всех адресов и количество вызовов этого адреса.

Опишем вызовы.

nginx
GET /statistic
Ответ от сервера JSON.

less
{
{url : URL, total : 0},
{url : "https://job4j.ru/profile/exercise/106/task-view/532", total : 103}
}

![alt text](image/1.png)
![alt text](image/2.png)
![alt text](image/3.png)
![alt text](image/4.png)
![alt text](image/5.png)
![alt text](image/6.png)
![alt text](image/7.png)
![alt text](image/8.png)
