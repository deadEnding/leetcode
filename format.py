#!/usr/bin/env python
# -*- coding: utf-8 -*-

import sys

if __name__ == '__main__':
    if len(sys.argv) != 3:
        print "Usage: format.py cpp|java <string>"
        exit(0)

    n, t, s = sys.argv
    fs = ''.join([i.capitalize() for i in s.split(' ')])
    print fs if t == 'cpp' else 'L' + fs.replace('.', '_')
