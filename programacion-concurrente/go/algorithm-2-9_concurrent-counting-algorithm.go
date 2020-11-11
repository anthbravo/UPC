package main

import (
	"fmt"
	"time"
)

var n int

func p() {
	var temp int
	for i := 0; i < 10; i++ {
		time.Sleep(100)
		temp = n
		n = temp + 1
		fmt.Println("P: ", n)
	}
}

func q() {
	var temp int
	for i := 0; i < 10; i++ {
		time.Sleep(100)
		temp = n
		n = temp + 1
		fmt.Println("Q: ", n)
	}
}

func main() {
	go p()
	go q()
	time.Sleep(time.Second * 10)
}
