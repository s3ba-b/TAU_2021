using System;
using Xunit;
using lib;

namespace tests
{
    public class UnitTest1
    {
        [Fact]
        public void Test1()
        {
            new Client().Main();
        }
    }
}
