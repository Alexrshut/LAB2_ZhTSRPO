# :airplane: __AlexFly__

____

## :clipboard: __Оглавление__

- __[1. Введение](#intro)__
- __[2. Требования пользователя](#user_requirements)__
  - __[2.1 Программные интерфейсы](#interfaces)__
  - __[2.2 Интерфейс пользователя](#ui)__
  - __[2.3 Характеристики пользователей](#user_characteristics)__
  - __[2.4 Предположения и зависимости](#assumptions)__
- __[3. Системные требования](#system_requirements)__
  - __[3.1 Функциональные требования](#functional_requirements)__
  - __[3.2 Нефункциональные требования](#non_functional_requirements)__
  - 
___

<a name="intro"></a>
## :newspaper: __1. Введение__

__Название проекта: [AlexFly](https://github.com/Alexrshut/LAB2_ZhTSRPO)__

__Технологии и инструменты разработки:__

•	_Язык разработки: ___Kotlin___._

•	_Фреймворк для создания UI: ___XML___._

•	_Среда разработки: ___Android Studio___._

__Описание проекта:__  
Проект представляет собой мобильное приложение для покупики авиобилетов, их сортировки для нахождения наилучшего предложения, а также личный кабинет, где можно просматривать историю покупок.

__Границы проекта:__  
Приложение не предоставляет функций карты (географических), банковских услуг.

___

<a name="user_requirements"></a>
## :page_facing_up: __2. Требования пользователя__

<a name="interfaces"></a>
### __2.1 Программные интерфейсы:__

__Продукт будет взаимодействовать с несколькими внешними системами:__

• _Firebase Authentication для авторизации и хранения данных пользователей._

• _Transaction Database для локального хранения информации о различных рейсах._

<a name="ui"></a>
### __2.2 Интерфейс пользователя:__

__Приложение будет содержать следующие основные интерфейсы__:

• __Окно загрузки приложения__.
  
  _Ещё находится в стадии разработки._

• __Стартовое окно при входе в приложение__.
  
  ![Стартовое окно при входе в приложение](https://github.com/Alexrshut/LAB2_ZhTSRPO/blob/main/mocaps/main_screen.png)

• __Окно выбора даты туда__.
  
  ![Окно выбора даты туда](https://github.com/Alexrshut/LAB2_ZhTSRPO/blob/main/mocaps/data_screen_there.png)

• __Окно выбора даты обратно _(если требуется)___.
  
  ![Окно выбора даты обратно](https://github.com/Alexrshut/LAB2_ZhTSRPO/blob/main/mocaps/data_screen_back.png)

• __Окно выбора количества мест и класса__.
  
  ![Окно выбора количества мест и класса](https://github.com/Alexrshut/LAB2_ZhTSRPO/blob/main/mocaps/quantity_and_baggage_screen.png)

• __Окно выбора точки вылета__.
  
  ![Окно выбора точки прилёта](https://github.com/Alexrshut/LAB2_ZhTSRPO/blob/main/mocaps/place_of_arrival_screen.png)

• __Окно выбора точки прилёта__.
  
  ![Окно выбора точки обратно](https://github.com/Alexrshut/LAB2_ZhTSRPO/blob/main/mocaps/place_of_arrival_screen.png)

• __Окно с результатом поиска__.

  ![Информация о рейсе](https://github.com/Alexrshut/LAB2_ZhTSRPO/blob/main/mocaps/search_results_screen.png)

• __Окно с информацией о выбранной рейсе__.

  ![Информация о рейсе](https://github.com/Alexrshut/LAB2_ZhTSRPO/blob/main/mocaps/about_the_flight_screen.png)

• __Вход в личный кабинет__.

  ![Вход в личный кабинет](https://github.com/Alexrshut/LAB2_ZhTSRPO/blob/main/mocaps/buy_tickets_screen.png)


__Пример взаимодействия:__

| Действие пользователя                          | Реакция системы                                               |
|------------------------------------------------|---------------------------------------------------------------|
| Выберите "Минск" в стартовом окне            |Сортировка с точкой вылета "Минск"                          |
| Выберите "Санкт-Петербург" в стартовом окне            |Сортировка с точкой прилёта  "Минск"                          |
| Выберите "03.10.2024" в стартовом окне            |Сортировка с датой вылета "03.10.2024"                         |
| Выберите "05.10.2024" в стартовом окне            |Обратные сортировки с этой датой                        |
| Выберите "1 пассажир, бизнес" в стартовом окне            |Сортировка с билетом на 1 место в бизнес-класс                          |
| Выберите "Найти" в стартовом окне            |Переходит в окно с результатами поиска                         |
| Нажимаем на иконку устроившего нас рейса                      |Открывается окно с подробной информацией о рейсе     |
| Нажимает на иконку "Купить"       |Переходим в окно входа в личный кабинет   |
| Вводим логин и пароль                |Переходим в личный кабинет с купленным билетом             |

<a name="user_characteristics"></a>
### **2.3 Характеристики пользователей:**

•	Пользователи страше 18 лет: _Люди имеющие свой доход и имеющие право самостоятельно перелетать_.

•	Пользователи страше 12 лет: _Люди имеющие право летать, но не имеющие свой доход_.

<a name="assumptions"></a>
### **2.4 Предположения и зависимости:**

•	Все пользователи должны иметь подключение к интернету для синхронизации данных с облаком.

•	Приложение будет работать только на устройствах с Android 6.0 и выше.

___

<a name="system_requirements"></a>
## :computer: **3. Системные требования**

<a name="functional_requirements"></a>
### **3.1 Функциональные требования:**

• Приложение должно позволять пользователям находить, изучать, покупать и просматривать купленные билеты

• Приложение должно иметь понятный графический интерфейс для простого восприятия пользователем.

• Авторизация должна быть обязательной для сохранности личных данных и билетов пользователей.

• Приложение должно поддерживать синхронизацию данных с облаком (Firebase).

<a name="non_functional_requirements"></a>
### **3.2 Нефункциональные требования:**

•	__Надёжность__: Приложение должно быть устойчивым к потерям соединения с интернетом, с возможностью локального хранения данных и последующей синхронизации.

•	__Безопасность__: Данные пользователей должны быть защищены, а авторизация — проводиться через надёжную систему (например, Firebase Authentication).

•	__Производительность__: Приложение должно загружаться и работать плавно на большинстве современных устройств.

•	__Удобство использования__: Интерфейс должен быть интуитивно понятным, особенно для пользователей с базовыми техническими навыками.

___