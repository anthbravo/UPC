import numpy as np

inputs = np.array([[0, 0, 1], [0, 1, 0], [0, 1, 1], [1, 0, 0], [1, 0, 1], [1, 1, 0], [1, 1, 1]])
expectedOutputs = np.array([[1], [2], [3], [4], [5], [6], [7]])

weights = np.array([0.84, 0.394, 0.783])
learningRate = 0.3

epochs = 7
amountOfData = 3


def calculateSumOfWeight(inputs, weights, row):
    sum = 0;
    for column in range(amountOfData):
        sum += inputs[row][column] * weights[column]
    return sum


def isNeedLearning(sumOfWeight, expectedOutputs, row):
    return sumOfWeight != expectedOutputs[row][0]


def calculateError(sumOfWeight, expectedOutputs, row):
    return expectedOutputs[row][0] - sumOfWeight


def modifiedWeights(inputs, row, error):
    for column in range(amountOfData):
        errorOfWeight = learningRate * error * inputs[row][column]
        print("row: " + str(row) + ", column: " + str(column) + ", before weight:" + str(weights[column]))
        weights[column] = errorOfWeight + weights[column]
        print("row: " + str(row) + ", column: " + str(column) + ", after weight:" + str(weights[column]))


def learning():
    for row in range(epochs):
        sumOfWeight = calculateSumOfWeight(inputs, weights, row)
        if (isNeedLearning(sumOfWeight, expectedOutputs, row)):
            error = calculateError(sumOfWeight, expectedOutputs, row)
            modifiedWeights(inputs, row, error)


learning()
