# Лабораторная работа №4

## Описание предметной области, по которой должна быть построена объектная модель:

Убедившись, что пули не причиняют ракете вреда, Ригль снова взмахнул дубинкой и закричал. Не прекращая пальбы из ружей, полицейские побежали вперед. Подбежав к ракете, они с яростью набросились на установленные вокруг приборы и принялись уничтожать их: разбили барометр, разломали сейсмограф, изрешетили пулями дождемер, наконец полезли на вышку, чтоб разбить анемометр.

// Start of lab4..

– Это что же за варварство такое! – вскипел от негодования Знайка. Ну, подождите-ка, я покажу вам!
С этими словами он включил прибор невесомости. Полицейские, которые не ожидали никакого подвоха, в ту же секунду почувствовали, что почва ушла из-под их ног.



## Реализация

### Общие сведения

Проект включает в себя абстрактный класс `Person` для базовых сущностей и конкретный класс `Znayka`, объединяющий общее поведение через интерфейсы:
- `Sayable` с методом `say(String words)`
- `Angryable` с методом `becomeAngry()`
- `Turnable` с методом `turnOn()`

Введены два новых класса `Gravity` и `Sense` для взаимодействия полицейских и Знайки.

### Задачи лабораторной работы

В лабораторной работе необходимо было реализовать:
1. Checked и Unchecked исключения
2. Локальный класс
3. Анонимный класс
4. Вложенный static и non-static класс

### Реализация исключений

**Unchecked исключение** возникает, если на вход метода `say(String words)` подается нерусский язык:

```java
@Override
public void say(String word) throws IllegalLanguageException {
    if (!word.matches("^[а-яА-ЯёЁ\\s!,\\-]+$")) {
        throw new IllegalLanguageException("Текст должен быть на русском языке");
    }
    System.out.println(this + " говорит: " + word);
}



Checked исключение обрабатывается, если изменение гравитации при использовании turnOn() слишком велико:
while (true) {
    try {
        znayka.turnOn();
        break; // Если исключения не было, выходим из цикла
    } catch (IllegalGravityException e) {
        // Обработка исключения
    }
}


Вложенные классы
Нестатический вложенный класс BalanceAttempt используется для попытки удержаться в воздухе:

private class BalanceAttempt {
    void tryToBalance() {
        // Реализация метода
    }
}


Статический вложенный класс Ground используется для моделирования взаимодействия с землей:
public static class Ground {
public void colideWithPerson(Policemen policemen, String person) {
        // Реализация метода
    }
}

Локальный класс `ReactionToAntiGravity` используется для имитации реакции полицейского на отсутствие гравитации:

```java
public void feel(String what) {
    // ...
    class ReactionToAntiGravity {
        void react() {
            // Реализация метода
        }
    }
    ReactionToAntiGravity reaction = new ReactionToAntiGravity();
    reaction.react();
    // ...
}


Этот класс определен внутри метода и используется для немедленного реагирования на изменения в окружающей среде, что отлично демонстрирует принцип инкапсуляции и обеспечивает локализацию поведения в пределах метода.

Анонимный класс

реализует уход почвы из под ног полицейского (вместо создания класса Soil мой выбор пал на анонимный класс)
   
policemen[0].feelGroundShift(new GroundShiftable() {
            @Override
            public void shift() {
                System.out.println("Почва ушла из-под ног у персонажа - " + policemen[0].toString());
                policemen[0].setMood(Mood.RAGE.getDescription());

  }
  });

policemen[1].feelGroundShift(new GroundShiftable() {
  @Override
  public void shift() {
      System.out.println("Почва ушла из-под ног у персонажа - " + policemen[1].toString());
      policemen[0].setMood(Mood.RAGE.getDescription());
            }
        });



   
