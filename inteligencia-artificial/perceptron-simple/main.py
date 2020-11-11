# perceptron simple for two entry
# Data Or's table for learn simple neuronal
dataOr = [[-1, -1, -1], [1, -1, 1], [-1, 1, 1], [1, 1, 1]]

# Initial Configuration
independentTerm = -0.5
weight_1 = 0
weight_2 = 2


# Functions
def ruleOfPropagation(data):
    return data[0] * weight_1 + data[1] * weight_2 + independentTerm


def activationWithSteppedModel(resultOfRuleOfPropagation):
    if (resultOfRuleOfPropagation > 0):
        return 1
    return -1


def optimizeWithSteppedModel(data):
    global weight_1, weight_2, independentTerm
    weight_1 = weight_1 + data[2] * data[0]
    weight_2 = weight_2 + data[2] * data[1]
    independentTerm = independentTerm + data[2]


def learning():
    for data in dataOr:
        print_variables("Start")
        resultOfRuleOfPropagation = ruleOfPropagation(data)
        resultOfActivation = activationWithSteppedModel(resultOfRuleOfPropagation)
        if (resultOfActivation != data[2]):
            optimizeWithSteppedModel(data)
        print_variables("End")


def print_variables(message):
    print("----------------" + message + "-----------------------")
    print("weight_1: ", weight_1)
    print("weight_2: ", weight_2)
    print("independentTerm: ", independentTerm)
    print("-------------------------------------------")


learning()
