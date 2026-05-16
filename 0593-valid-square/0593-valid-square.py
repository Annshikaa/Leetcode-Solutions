class Solution:
    def validSquare(self, p1: List[int], p2: List[int], p3: List[int], p4: List[int]) -> bool:
        points = [p1, p2, p3, p4]

        distances = []

        for i in range(4):
            for j in range(i + 1, 4):
                x1,y1 = points[i]
                x2,y2 = points[j]

                dist = (x2 - x1)**2 + (y2 - y1)**2

                distances.append(dist)

        distances.sort()

        return (
            distances[0] > 0 and distances[0] == distances[1] == distances[2] == distances[3] and distances[4] == distances[5]
        )