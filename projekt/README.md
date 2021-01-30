# Moq

## Co to takiego?

Najpopularniejszy i najbardziej przyjazny framework do tworzenia atrap w .NET. Ma być prosty w użyciu, silnie typowany oraz minimalistyczny.

## Krótka (?) historia

Moq powstał, kiedy najpopularniejszym frameworkiem do atrap był Rhino Mocks. Moq był budowany od początku w oparciu o wyrazenia lambda, przez co zdobył przewagę nad Rhino, którego syntatyka sprawiała wiele problemów. Poza tym, w Rhino były dwa rodzaje atrap: stub i mock, podczas gdy w Moq wszystko uproszczono do jednego typu. Z czasem Rhino przestało się rozwijać i zapomniano o nim, a Moq zyskał dwóch konkurentów FakeItEasy oraz NSubstitute. Moq w dalszym ciągu jest konkurencyjny.

## Przykłady

### Projekt z testami

W katalogu samples/tests/

### Ustawianie metod asynchronicznych

mock.Setup(foo => foo.DoSomethingAsync().Result).Returns(true);

mock.Setup(foo => foo.DoSomethingAsync()).ReturnsAsync(true);

mock.Setup(foo => foo.DoSomethingAsync()).Returns(async () => 42);

### Dopasowywanie argumentów

mock.Setup(foo => foo.DoSomething(It.IsAny<string>())).Returns(true);

mock.Setup(foo => foo.Submit(ref It.Ref<Bar>.IsAny)).Returns(true);

mock.Setup(foo => foo.Add(It.Is<int>(i => i % 2 == 0))).Returns(true);

mock.Setup(foo => foo.Add(It.IsInRange<int>(0, 10, Range.Inclusive))).Returns(true);

mock.Setup(x => x.DoSomethingStringy(It.IsRegex("[a-d]+", RegexOptions.IgnoreCase))).Returns("foo");

### Właściwości

mock.Setup(foo => foo.Name).Returns("bar");

mock.Setup(foo => foo.Bar.Baz.Name).Returns("baz");

mock.SetupSet(foo => foo.Name = "foo");

mock.VerifySet(foo => foo.Name = "foo");

#### Stub

mock.SetupProperty(f => f.Name);
mock.SetupProperty(f => f.Name, "foo");
IFoo foo = mock.Object;
Assert.Equal("foo", foo.Name);
foo.Name = "bar";
Assert.Equal("bar", foo.Name);

mock.SetupAllProperties();

### Zdarzenia

mock.SetupAdd(m => m.FooEvent += It.IsAny<EventHandler>())...;
mock.SetupRemove(m => m.FooEvent -= It.IsAny<EventHandler>())...;

mock.Raise(m => m.FooEvent += null, new FooEventArgs(fooValue));

mock.Raise(m => m.FooEvent += null, this, new FooEventArgs(fooValue));

mock.Raise(m => m.Child.First.FooEvent += null, new FooEventArgs(fooValue));

mock.Setup(foo => foo.Submit()).Raises(f => f.Sent += null, EventArgs.Empty);

public delegate void MyEventHandler(int i, bool b);
public interface IFoo
{
  event MyEventHandler MyEvent; 
}

var mock = new Mock<IFoo>();

[ ... ]

mock.Raise(foo => foo.MyEvent += null, 25, true);

### Wywołania zwrotne

var mock = new Mock<IFoo>();
var calls = 0;
var callArgs = new List<string>();

mock.Setup(foo => foo.DoSomething("ping"))
    .Callback(() => calls++)
    .Returns(true);

mock.Setup(foo => foo.DoSomething(It.IsAny<string>()))
    .Callback((string s) => callArgs.Add(s))
    .Returns(true);

mock.Setup(foo => foo.DoSomething(It.IsAny<string>()))
    .Callback<string>(s => callArgs.Add(s))
    .Returns(true);

mock.Setup(foo => foo.DoSomething(It.IsAny<int>(), It.IsAny<string>()))
    .Callback<int, string>((i, s) => callArgs.Add(s))
    .Returns(true);

mock.Setup(foo => foo.DoSomething("ping"))
    .Callback(() => Console.WriteLine("Before returns"))
    .Returns(true)
    .Callback(() => Console.WriteLine("After returns"));

delegate void SubmitCallback(ref Bar bar);

mock.Setup(foo => foo.Submit(ref It.Ref<Bar>.IsAny))
    .Callback(new SubmitCallback((ref Bar bar) => Console.WriteLine("Submitting a Bar!")));

var mock = new Mock<IFoo>();
var calls = 0;
mock.Setup(foo => foo.GetCount())
	.Callback(() => calls++)
	.Returns(() => calls);

Console.WriteLine(mock.Object.GetCount());

mock.SetupProperty(foo=>foo.Bar);
mock.Setup(foo => foo.DoSomething(It.IsAny<string>()))
    .Callback((string s) => mock.Object.Bar=s)
    .Returns(true);

### Weryfikacja

mock.Verify(foo => foo.DoSomething("ping"));

mock.Verify(foo => foo.DoSomething("ping"), "When doing operation X, the service should be pinged always");

mock.Verify(foo => foo.DoSomething("ping"), Times.Never());

mock.Verify(foo => foo.DoSomething("ping"), Times.AtLeastOnce());

mock.VerifyGet(foo => foo.Name);

mock.VerifySet(foo => foo.Name);

mock.VerifySet(foo => foo.Name ="foo");

mock.VerifySet(foo => foo.Value = It.IsInRange(1, 5, Range.Inclusive));

mock.VerifyAdd(foo => foo.FooEvent += It.IsAny<EventHandler>());
mock.VerifyRemove(foo => foo.FooEvent -= It.IsAny<EventHandler>());

mock.VerifyNoOtherCalls();

## Referencje

- https://dariuszwozniak.net/posts/kurs-tdd-15-wstep-do-moq
- https://github.com/moq/moq4/wiki/Quickstart
- https://www.nuget.org/packages/Moq/