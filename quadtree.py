def reverse():
    global iterator, inputString
    
    iterator += 1
    
    head = inputString[iterator]
    if head=='b' or head=='w':
        return head
    
    upperLeft = reverse()
    upperRight = reverse()
    lowerLeft = reverse()
    lowerRight = reverse()
    
    return "x" + lowerLeft + lowerRight + upperLeft + upperRight


if __name__ == '__main__':
    testCase = input()
        
    for i in range(int(testCase)):
        iterator = -1
        inputString = input()
        print(reverse())
