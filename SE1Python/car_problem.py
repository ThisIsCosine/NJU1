def locate_car_problem():
    if input("Is the car silent when you turn the key?") == 'y':
        if input("Are the battery terminals corroded?") == 'y':
            print("Clean terminals and try starting again.")
        else:
            print("Replace cables and try again.")
    else:
        if input("Does the car make a clicking noise?") == 'y':
            print("Replace the battery.")
        else:
            if input("Does the car crank up but fail to start?") == 'y':
                print("Check spark plug connections.")
            else:
                if input("Does the engine start and then die?") == 'y':
                    if input("Does your car have fuel injection?") == 'n':
                        print("Check to ensure the choke is opening and closing.")
                    else:
                        print("Get it in for service.")
    return

if __name__ == '__main__':
    locate_car_problem()