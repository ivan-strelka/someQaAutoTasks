
# В этом репозитаории содержатся UI Selenide + API Rest Assured автотесты

## UI тесты. Пакет appleInsider. Тест кейс №1

1. Открыть сайт appleinsider.ru
2. Нажать на кнопку поиска сверху справа
3. Ввести текст "Чем iPhone 13 отличается от iPhone 12" и нажать Enter
4. В найденных статьях получить href атрибут первой найденной статьи
5. Убедиться, что href ссылка содержит слово Iphone 13 (обрати внимание как это слово выглядит в href ссылке)

## UI тесты. Пакет hh. Тест кейс №2 
1) Открыть резюме, которое доступно только по ссылке: qwerty
2) Получить информацию о профиле, используя HashMap или Class, в которой должны быть следующие атрибуты:
String sex, int age, String city, boolean confirmedPhoneNumber, boolean readyToRelocate;
3) Убедится, что ожидаемый результат и актуальный равны

Ожидаемый результат sex = "М", age = 25, city = "Санкт-Петербург", confirmedPhoneNubmer = true, readyToRelocate = false; 

## API тесты. Пакет api. Тесты для методов GET/POST/DELETE/PUT для Rest Assured с использованием Specifications
Test_1
1. Используя сервис https://jsonplaceholder.typicode.com/ получить список пользователей (users)
2. Убедиться, что у 2 пользователей отличается формат записи поля "phone"

Test_2
1.Используя сервис https://jsonplaceholder.typicode.com/ получить список фотографий "photos"
2.Подсчитать точное количество альбомов и сколько пользователей в них

Test_3
1.Используя сервис https://jsonplaceholder.typicode.com/ получить список фотографий "photos"
2.Убедиться, что поля "url" и "thumbnailUrl" совпадают

Test_4
1.Используя сервис https://jsonplaceholder.typicode.com/ получить 5 по счету пост
2. найти в нем id с той же цифрой(5)

## Selenium + FindBy + PageFactory

## typesafe config properties 
