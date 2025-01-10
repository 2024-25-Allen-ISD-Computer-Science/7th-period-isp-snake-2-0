import turtle
import time
import random


delay = 0.1
score = 0
high_score = 0


wn = turtle.Screen()
wn.title("Snake Game")
wn.bgcolor("blue")
# the width and height can be put as user's choice

#Snake head
head = turtle.Turtle()
head.shape("square")
head.color("green")
head.speed(0)
head.penup()
head.goto(0,0)
head.direction = "stop"

#Snake food
food = turtle.Turtle()
food.speed(0)
food.shape("circle")
food.color("red")
food.penup()
food.goto(0,100)

segments = []

#Pen
pen = turtle.Turtle()
pen.speed(0)
pen.shape("square")
pen.color("white")
pen.speed(0)
pen.penup()
pen.hideturtle()
pen.goto(0 , 260)
pen.write("Score: 0  High Score: 0", align = "center", font=("Courier", 24, "normal"))

#Functions xcor and ycor are from the turtle module



def go_up():
    if head.direction != "down":
        head.direction = "up"
        
def go_down():
    if head.direction != "up":
        head.direction = "down"
        
def go_left():
    if head.direction != "left":
        head.direction = "right"
        
def go_right():
    if head.direction != "left":
        head.direction = "right"
        
def move1():
    if head.direction == "up":
        y = head.ycor()
        head.sety(y + 20)
        
    if head.direction == "down":
        y = head.ycor()
        head.sety(y - 20)
        
    if head.direction == "left":
        x = head.xcor()
        head.setx(x - 20)
        
    if head.direction == "right":
        x = head.xcor()
        head.setx(x + 20)
        
# Keyboard bindings
wn.listen()
wn.onkeypress(go_up, "w")
wn.onkeypress(go_down, "s")
wn.onkeypress(go_left, "a")
wn.onkeypress(go_right, "d")

# Main game loop

while True:
    wn.update()
    
    #Check for a collision with the border
    if head.xcor()>290 or head.xcor()<-290 or head.ycor()>290 or head.ycor() <-290:
        time.sleep(1)
        head.goto(0,0)
        head.direction = "stop"
        
        #Hide the segments
        for segment in segments:
          segment.goto(1000, 1000)
          
        #Clear the segments list
        segments.clear()
        
        #Reset the score
        score = 0
        
        #Reset the delay
        delay = 0.1
        
        pen.clear()
        pen.write("Score: {} High Score: {}".format(score, high_score), align="center", font=("Courier", 24, "normal"))
        
        

     
    if head.distance(food) < 20:
        x = random.randint(-300,300)
        y = random.randint(300, 300)
        food.goto(x,y)
        
        #Adds a new segment
        new_segment = turtle.Turtle()
        new_segment.speed(0)
        new_segment.shape("square")
        new_segment.color("grey")
        new_segment.penup()
        segments.append(new_segment)
        
        #Shorten delay
        
        delay -= 0.001
        
        #Increase score
        
        score += 10
        
        if score > high_score:
            high_score = score
            
        pen.clear()
        pen.write("Score: {} High Score: {}".format(score, high_score), align="center", font=("Courier", 24, "normal"))
        
        
    for index in range(len(segments)-1, 0, -1):
        x = segments[index-1].xcor()
        y = segments[index-1].ycor()
        segments[0].goto(x,y)
        
    if len(segments) > 0:
        x = head.xcor()
        y = head.ycor()
        segments[0].goto(x,y)
        
    move1()
    
    #Check for head collision with the body segments
    for segment in segments:
        if segment.distance(head) < 20:
            time.sleep(1)
            head.goto(0,0)
            head.direction = "stop"
            
            #Hide the segments
            for segment in segments:
                segment.goto(1000, 1000)
                
            #Clear the segments list
            segments.clear()
            
            #Reset the score
            score = 0
            
            #Reset the delay
            delay = 0.1
            
            #Update the score display
            pen.clear()
            pen.write("Score: {} High Score: {}".format(score, high_score), align="center", font=("Courier", 24, "normal"))
            
    time.sleep(delay)

wn.mainloop()