package main

import (
	"fmt"
	"time"
)

var turn int = 1
var counter int = 0

func p() {
	for true {
		if counter == 10 {
			break
		}
		if turn == 1 {
			counter++
			fmt.Println("P: ", counter)
			turn = 2
		}
	}
}

func q() {
	for true {
		if counter == 10 {
			break
		}
		if turn == 2 {
			counter++
			fmt.Println("Q: ", counter)
			turn = 1
		}
	}
}

func main() {
	go p()
	go q()
	time.Sleep(time.Second * 1)
}
