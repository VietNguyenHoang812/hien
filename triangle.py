import math


class Point():
    def __init__(self, x: int, y: int) -> None:
        self.x = x
        self.y = y

    def setPoint(self, x: int, y: int) -> None:
        self.x = x
        self.y = y

    def getx(self) -> int:
        return self.x
    
    def gety(self) -> int:
        return self.y
    
def distance(a: Point, b: Point) -> float:
    return math.sqrt((a.getx() - b.getx())*(a.getx() - b.getx()) + (a.gety() - b.gety())*(a.gety() - b.gety()))

class Triangle():
    def __init__(self, a: Point, b: Point, c: Point) -> None:
        self.a = a
        self.b = b
        self.c = c

    def getPerimeterFloat(self) -> float:
        ab = distance(self.a, self.b)
        bc = distance(self.b, self.c)
        ca = distance(self.c, self.a)
        perimeter = ab + bc + ca

        return perimeter
    
    def getPerimeter(self) -> int:
        return math.floor(self.getPerimeterFloat())
    
    def getAreaFloat(self) -> float:
        ab = distance(self.a, self.b)
        bc = distance(self.b, self.c)
        ca = distance(self.c, self.a)
        half_peri = self.getPerimeterFloat()/2
        area = math.sqrt(half_peri*(half_peri-ab)*(half_peri-bc)*(half_peri-ca))
        
        return area
    
    def getArea(self) -> int:
        return math.floor(self.getAreaFloat())
    
    def toString(self) -> str:
        string = f"Triangle: A({self.a.getx()}, {self.a.gety()}), B({self.b.getx()}, {self.b.gety()}), C({self.c.getx()}, {self.c.gety()})"
        return string


if __name__ == "__main__":
    a, b, c = Point(1, 1), Point(1, 2), Point(2, 1)
    x = Triangle(a, b, c)
    print(x.toString())
    print(x.getPerimeterFloat(), x.getPerimeter())
    print(x.getAreaFloat(), x.getArea())