# language: ru
@all @1
Функция: Проверка элементов основной страницы
  Предыстория:
    Дано 'основная страница' успешно загружена

  Сценарий: Проверка текстовых символов
    И 'универсальные действия' вводит "abcdesasasqasasasasasas" в поле поиска
    И 'универсальные действия' очищает поле поиска

  Сценарий: Проверка цифровых символов
    И 'универсальные действия' вводит "123456" в поле поиска
    И 'универсальные действия' очищает поле поиска

  Сценарий: Проверка спец символов
    И 'универсальные действия' вводит "*?:%;№!" в поле поиска
    И 'универсальные действия' очищает поле поиска
    И 'универсальные действия' в тулбаре нажимает на ссылку "Спорт"







