using System;
using Xunit;
using AbstractFactory;
using Moq;

namespace tests
{
    public class UnitTest1
    {
        [Fact]
        public void Test()
        {
            var concreteProductA1Mock = new Mock<IAbstractProductA>();
            concreteProductA1Mock.Setup(abstractProduct => abstractProduct.UsefulFunctionA()).Returns("The result of the product A1.");
            var concreteProductA2Mock = new Mock<IAbstractProductA>();
            concreteProductA2Mock.Setup(abstractProduct => abstractProduct.UsefulFunctionA()).Returns("The result of the product A2.");

            var concreteProductB1Mock = new Mock<IAbstractProductB>();
            concreteProductB1Mock.Setup(abstractProduct => abstractProduct.UsefulFunctionB()).Returns("The result of the product B1.");
            var concreteProductB2Mock = new Mock<IAbstractProductB>();
            concreteProductB2Mock.Setup(abstractProduct => abstractProduct.UsefulFunctionB()).Returns("The result of the product B2.");

            var concreteFactory1Mock = new Mock<IAbstractFactory>();
            concreteFactory1Mock.Setup(abstractFactory => abstractFactory.CreateProductA()).Returns(concreteProductA1Mock.Object);
            concreteFactory1Mock.Setup(abstractFactory => abstractFactory.CreateProductB()).Returns(concreteProductB1Mock.Object);
            var concreteFactory2Mock = new Mock<IAbstractFactory>();
            concreteFactory2Mock.Setup(abstractFactory => abstractFactory.CreateProductA()).Returns(concreteProductA2Mock.Object);
            concreteFactory2Mock.Setup(abstractFactory => abstractFactory.CreateProductB()).Returns(concreteProductB2Mock.Object);
        }
    }
}
