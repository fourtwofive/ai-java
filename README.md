# 🎨 색상 가득한 계산기 (SimpleCalculator)

Java Swing을 이용한 **예쁜 GUI 계산기**입니다.  
사칙연산(+, -, *, /)을 지원하며, 다양한 색상으로 꾸며진 사용자 친화적인 인터페이스를 제공합니다.

## 📌 프로젝트 소개

이 프로젝트는 Java의 **Swing 라이브러리**를 활용하여 만든 간단한 데스크톱 계산기입니다.  
초보자도 쉽게 이해하고 커스터마이징할 수 있도록 코드가 깔끔하게 작성되었습니다.

### 주요 기능
- 두 숫자를 입력받아 사칙연산 수행
- 0으로 나누기 오류 처리
- 숫자 입력 오류 처리
- 예쁜 색상 테마 (Cornflower Blue, Light Pink, Lemon Chiffon 등)
- 상단에 타이틀 + 아이콘 표시
- 모달 다이얼로그로 결과 출력

---

## 📁 프로젝트 구조

```bash
SimpleCalculator/
├── README.md
├── src/
│   └── test/
│       ├── SimpleCalculator.java     # 메인 소스 파일
│       └── calc_icon.png             # (선택) 상단 아이콘 이미지
└── bin/        
```


## 🚀 실행 방법

### 1. 명령줄에서 실행하기# 컴파일 후 클래스 파일 (자동 생성)
```
# 1. src/test 폴더로 이동
cd src/test

# 2. 컴파일
javac SimpleCalculator.java

# 3. 실행
java test.SimpleCalculator
```
### 2. IDE 추천

- IntelliJ IDEA (가장 추천)
- Eclipse
- VS Code + Java Extension Pack


## 💡 코드 주요 개념 설명

- BorderLayout: 상단·중앙·하단 배치에 사용
- GridLayout: 입력 필드와 버튼을 격자 형태로 배치
- 내부 클래스 (CalcListener): 이벤트 리스너를 간결하게 구현
- 예외 처리: try-catch로 잘못된 입력 방지
- 색상 적용: new Color(r, g, b)와 setBackground()
