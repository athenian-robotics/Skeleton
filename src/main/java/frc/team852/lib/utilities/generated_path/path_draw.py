import csv
import sys
import math
import time
import turtle

def draw(fname=None):
    fname = fname or 'path_test.csv'
    with open(fname) as f:
        l = list(csv.reader(f))
    
    l = l[:len(l)//2 - 2]
    l = [map(float, p[:-1]) for p in l]
    
    import turtle
    t = turtle.Turtle()
    t.speed(0)
    
    for p in l:
        t.setheading(math.degrees(math.atan2(p[3], p[2])))
        t.goto(p[0] * 40, p[1] * 40)
        time.sleep(0.05)
    
    time.sleep(2)

if __name__ == '__main__':
    fname = (sys.argv + [None])[1]
    draw(fname)
