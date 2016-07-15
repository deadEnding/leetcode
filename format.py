#!/usr/bin/env python
# -*- coding: utf-8 -*-

import sys

if __name__ == '__main__':
    if len(sys.argv) != 2:
        print "Usage: format.py <string>"
        exit(0)

    s = sys.argv[1]
    print ''.join([i.capitalize() for i in s.split(' ')])
