#!/usr/bin/env python
# -*- coding: utf-8 -*-

import sys

if __name__ == '__main__':
    s = sys.argv[1]
    print ''.join([i.capitalize() for i in s.split(' ')])
