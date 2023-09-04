#include <iostream>
using namespace std; /*变量空间 新概念，：line */

/*关键字extern的用法：可以在一个文件中（函数外）使用extern声明一个变量说明次变量来自其他文件，被本文件引用，此时这个变量的作用域是此文件
 * 也可在一个函数中使用extern，只不过此时这个变量的作用域是这个函数
 * 被引用的变量在其他文件中必须为全局变量
 extern的其他用法以后用到再补充*/
/*
extern int a;
extern int b;//由于没有其他文件定义a，b，此处声明等于全局变量
 */

/*关于全局变量的小细节：如果全局变量和某一函数中的局部变量同名，则在此函数中，全局变量暂时被局部变量覆盖*/

/*c++的输入输出，引用头文件 iosteam， （感觉类似stdio） 用cin和cout以及<<, >>运算符，不使用printf scanf,对于流的更多输入以后介绍*/

/*
 * int main() {
    int a = 1;
    cin >> a;
    cout << "Hello, World!:" << a << endl;
    return 0;
}
 */

/*
 * c++的面向对象编程，（C语言中没有此类设定），类的运用
 * c++中类与结构体相似
 * 与C语言不同的是
 * c++中struct和class中都可以添加函数
 * 只不过struct中的变量均为public，在何处都可访问，
 * 而class中的变量有三种类型public， protected， private
 * public修饰的变量与struct的变量性质相同，
 * private则相反，在本class外不可被访问
 * protect的性质介于两者之间：在本类和派生类（子类）中可以被访问，在其他地方不可被访问，派生类（子类）：line
 */
/*
 * 这是一个使用类的小程序，输入长方体六面盒子的长宽高以及墙壁的厚度，输出墙壁的体积
 * /

/*
 #include <iostream>
using namespace std;

class Box {
public:
    double length, width, height, WallWidth, WallVolume;
private:
    double MaxVolume, MinVolume;
private:
    double Max(double length, double  width, double height);
    double Min(double length, double  width, double height, double WallWidth);
public:
    void SetAnswer(double length, double width, double height, double WallWidth);
};

double Box::Max(double length1, double width1, double height1) {
    return length1 * width1 * height1;
}

double Box::Min(double length2, double width2, double height2, double  WallWidth2) {
    return (length2 - WallWidth2) * (width2 - WallWidth2) * (height2 - WallWidth2);
}

void  Box::SetAnswer(double length3, double width3, double height3, double WallWidth3) {
    MaxVolume = Max(length3, width3, height3);
    MinVolume = Min(length3, width3, height3, WallWidth3);
    WallVolume =  MaxVolume - MinVolume;
}

int main(){
    int l, w, h, wall;
    cin >> l;
    cin >> w;
    cin >> h;
    cin >> wall;
    Box ThisBox;
    ThisBox.SetAnswer(l, w, h, wall);
    cout << ThisBox.WallVolume << endl;
    return 0;

}
 */

#include <stdio.h>
#define F(x, y) x > y ? x : y

int main()
{
    int a = 2, b = 5, c;
    c = 4 + F(a, b);
    int d = 4 + (F(a, b));
    printf("c = %d    d = %d", c, d);
}