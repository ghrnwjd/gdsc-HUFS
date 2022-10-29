# 분 단위 나이계산기


## Linear Layout vs. Constraint Layout

<br/>

> ## Linear Layout
> 
> 어느 방향으로 뷰 층을 쌓을 것인가?
> 
> Horizontal 가로방향
> 
> Vertical 세로방향


<br/>

간단한 페이지 구성할 경우 `Linear Layout`을 사용하는 것이 좋음.
복잡한 페이지의 경우 Linear Layout을 중첩하게 되는데 어플리케이션을 무겁게 만듬.

<br/>

> ## Contraion Layout
> `상대적 위치` 관계에 따라 뷰가 표시될 영역을 지정하는 방법으로 레이아웃 중첩으로 인한 성능 이슈를 줄여주고 복잡성을 낮춰 유지보수에 유리.

<br/>

## TextView 속성
<br/>

```
android:layout_width="wrap_content"
android:layout_height="match_parent"
```
- wrap_content : 폭과 높이가 글자에 맞게 설정.
- match_parent : 자신의 부모에 폭이나 높이에 맞게 설정.

<br/>

```
android:text="Calculate YOUR"
android:textColor="@color/textBlue"
android:textSize="25sp"
android:textStyle="bold"
```
- text : 어떤 내용을 담을지
- textColor : 텍스트의 색깔을 어떤 색으로 할것인지 
- textSize : 텍스트의 크기
- textStyle : bold, italic 등

`textSize`의 경우 `dp`, `sp` 두가지의 단위가 있는데 `sp`를 사용하는 것이 권장된다.
`sp`의 경우 텍스트 의 크기가 자동으로 조절되어 텍스트의 가독성을 넓힌다.

`textColor` 의 경우 `/res/values/colors.xml` 에서 우리가 원하는 색상을 16진수로 지정해 사용할 수 있다.

```
android:id="@+id/myId"
```
레이아웃 파일에 TextView, Button 등에 id값을 설정하면 `R.java` 또는 `R.jar`파일을 통해 id값을 이름으로 하는 정수 타입의 변수를 생성하여 코드에서 해당 뷰를 참조할 수 있도록 한다.

여기서 R은 안드로이드 자원을 식별하기 위한 변수들을 관리하는 `클래스`로 `/res/layout/activity_main.xml` 파일은 코드에서 `R.layout.activity_main`으로 참조할 수 있으며 id를 설정해 둔 경우 `R.id.아이디값`으로 참조가 가능하다. 

```
tvSelectedDate = findViewById(R.id.tvSelectedDate)
tvAgeInMinutes = findViewById(R.id.tvAgeInMinutes)
```

## clickDataPicker() function

```
private fun clickDatePicker() {
    val myCalendar = Calendar.getInstance()
    val year = myCalendar.get(Calendar.YEAR)
    val month = myCalendar.get(Calendar.MONTH)
    val day = myCalendar.get(Calendar.DAY_OF_MONTH)

    val dpd = DatePickerDialog(this,
        DatePickerDialog.OnDateSetListener{
            view, selectedYear, selectedMonth,selectedDayOfMonth ->Toast.makeText(this,
                "Year was $selectedYear, month was ${selectedMonth+1}, " +  "day of month was $selectedDayOfMonth", Toast.LENGTH_LONG).show()

            val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"

            tvSelectedDate?.setText(selectedDate)
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.KOREA)
            val theDate = sdf.parse(selectedDate)

            theDate?.let{
                val selectedDateInMinutes = theDate.time / 60000
                // 여기서 ms 단위이기 때문에 60이 아니라 60000이다.

                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                currentDate?.let{
                    val currentDateInMinutes = currentDate.time / 60000
                    val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes

                    tvAgeInMinutes?.text = differenceInMinutes.toString()
                    }
                }
            },
            year,
            month,
            day
            )
//          Toast.makeText(this, "btnDatePicker pressed", 
            Toast.LENGTH_LONG).show()
          // Toast 란 버튼을 눌렀을 때 밑에 생기는 안냇말

    dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
    dpd.show()
    }
```


```
val myCalendar = Calendar.getInstance()
val year = myCalendar.get(Calendar.YEAR)
val month = myCalendar.get(Calendar.MONTH)
val day = myCalendar.get(Calendar.DAY_OF_MONTH)
```

`java.util` 라이브러리에 있는 Calender Class의 `getInstance()`함수를 통해 현재 날짜, 요일, 시간 정보를 가져와 각 변수에 저장한다.

<br/>

```
DatePickerDialog(this,
    DatePickerDialog.OnDateSetListener{
        view, selectedYear, selectedMonth,selectedDayOfMonth ->
        Toast.makeText(this,
            "Year was $selectedYear, month was ${selectedMonth+1}, " +
            "day of month was $selectedDayOfMonth", Toast.LENGTH_LONG).show()

        val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"

        tvSelectedDate?.setText(selectedDate)
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.KOREA)
        val theDate = sdf.parse(selectedDate)
```

람다식을 통해 사용자가 선택한 년, 월, 일을 전달받아 `Toast`로 화면에 띄어주고 `selectedDate` 변수에 저장하고 한국 날짜 포맷에 맞춰 `theDate` 변수에 파싱하여 저장한다.


```
theDate?.let{
    val selectedDateInMinutes = theDate.time / 60000
    // 여기서 ms 단위이기 때문에 60이 아니라 60000이다.

    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
        currentDate?.let{
            val currentDateInMinutes = currentDate.time / 60000
            val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes

            tvAgeInMinutes?.text = differenceInMinutes.toString()
        }
    }
},
year,
month,
day
)
    dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
    dpd.show()
}
```
`theDate`가 null이 아니라면 한시간이 60000ms 이므로 60000으로 나누어 저장한다.
그리고 현재시간을 `currentDate`에 `System.currentTimeMillis()` 함수를 통해 전달받아 차이를 계산하고 뷰 영역에 띄어줌으로 사용자에게 생년월일을 입력받아 현재의 시간으로 부터 차이를 계산하여 분 단위 나이계산기를 마무리했다.