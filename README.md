# online-store-of-computer

Для функционирования приложения необходимо подключить базу данных H2. База хранится в директории программы в /resources/db/store-db. До запуска необходимо в файле application.properties правильно указать директорию в которой находится БД, а также указать порт на котором будет работать приложение (по умолчанию 8085).
Во вкладке DataSource нажмите добавить DataSourceFromURL, указав при этом путь к БД (можно скопировать из application.properties) а также драйве H2. По умолчанию имя пользователя БД: sa, пароль отсутствует
В операционной системе должно быть установлено JDK и H2 Database Engine

Посте подключения БД и сборки проекта запустите SQL запрсы из директории /resources/db/schema.sql. Данный файл создаст четыре таблицы (desktop_computers, notebooks, monitors, hard_disks). По структуре таблицы идентичны, за исключение последнего поля. 

Программа содержит по четыре контроллера, сервиса и репозитория для работы с сущностями (DesktopComputers, Notebooks, Monitors, HardDisks).
Соответственно для работы с сущностями есть четыре основных end-poit (desktop_computers, notebooks, monitors, hard_disks) с помощью которых осуществляются манипуляции с данными:
1. вывод всех записей из таблицы
2. вывод по id записи
3. добавление записи
4. редактирование записи
5. удаление записи
