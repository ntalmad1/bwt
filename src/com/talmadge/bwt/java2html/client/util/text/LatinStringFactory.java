package com.talmadge.bwt.java2html.client.util.text;

import java.util.HashSet;

/**
 * 
 *
 */
public final class LatinStringFactory 
{
	/**
	 * 
	 * 
	 *
	 */
	protected static final class LatinString1 implements LatinString
	{
		
		/**
		 * Constructor 
		 *
		 * @param seq CharSequence
		 */
		LatinString1 (CharSequence seq)
		{
			thechar = (byte) seq.charAt(0);
		}
		
		
		/**
		 * Constructor 
		 * 
		 * @param ch char
		 */
		LatinString1 (char ch)
		{
			thechar = (byte) ch;
		}
		
		
		/**
		 */
		private byte thechar;
	
	
		@Override
		public char charAt (int index)
		{
			if (index == 0)
			{
				return (char) thechar;
			}
	
			throw new IndexOutOfBoundsException();
		}
	
	
		@Override
		public int length ()
		{
			return 1;
		}
	
	
		@Override
		public CharSequence subSequence (int start, int end)
		{
			if (start == 0)
			{
				if (end == 0)
				{
					return BLANK;
				}
				if (end == 1)
				{
					return this;
				}
			}
			throw new IndexOutOfBoundsException();
		}
	
	
		@Override
		public boolean equals (Object obj)
		{
			if (this == obj)
			{
				return true;
			}
			
			if (obj == null)
			{
				return false;
			}
			
			if (getClass() == obj.getClass())
			{
				return ((LatinString1) obj).thechar == thechar;
			}
			return equalsInternal(this, obj);
		}
	
	
		@Override
		public String toString ()
		{
			return toStringInternal(this);
		}
	
	
		@Override
		public int hashCode ()
		{
			return thechar;
		}
	
	}

	/**
	 * 
	 *
	 */
	protected static final class LatinString15 implements LatinString
	{
		/**
		 */
		private int length;
	
		/**
		 */
		private long chars;
	
		/**
		 */
		private int chars2;
	
	
		/**
		 * Constructor 
		 *
		 * @param chars long
		 * @param chars2 int
		 * @param length int
		 */
		LatinString15 (long chars, int chars2, int length)
		{
			if (length <= MAX_64_BIT_LENGTH)
			{
				this.chars = chars & LONG_MASK[length];
				this.chars2 = 0;
			}
			else
			{
				this.chars = chars;
				this.chars2 = chars2 & INT_MASK[length - MAX_64_BIT_LENGTH];
			}
			this.length = length;
		}
	
		
		/**
		 * Constructor 
		 *
		 * @param seq CharSequence
		 * @param length int
		 */
		LatinString15 (CharSequence seq, int length)
		{
			this.length = length;
			chars = ((seq.charAt(0) - 0x20) & 0x3F) + (((seq.charAt(1) - 0x20) & 0x3F) << SHIFT[1]) + (((seq.charAt(2) - 0x20) & 0x3F) << SHIFT[2]);
	
			for (int i = 3; i < MAX_64_BIT_LENGTH; i++)
			{
				chars += (((((long) seq.charAt(i)) - 0x20) & 0x3F) << SHIFT[i]);
			}
			for (int i = MAX_64_BIT_LENGTH; i < length; i++)
			{
				chars2 += (((((int) seq.charAt(i)) - 0x20) & 0x3F) << SHIFT[i - MAX_64_BIT_LENGTH]);
			}
	
		}
	
	
		@Override
		public char charAt (int index)
		{
			if (index >= length)
			{
				throw new IndexOutOfBoundsException();
			}
			if (index < 0)
			{
				throw new IndexOutOfBoundsException();
			}
			if (index < MAX_64_BIT_LENGTH)
			{
				return (char) (((chars >> SHIFT[index]) & 0x3F) + 0x20);
			}
			return (char) (((chars2 >> SHIFT[index - MAX_64_BIT_LENGTH]) & 0x3F) + 0x20);
	
		}
	
	
		@Override
		public int length ()
		{
			return length;
		}
	
	
		@Override
		public CharSequence subSequence (int start, int end)
		{
			if (end > length || start < 0)
			{
				throw new IndexOutOfBoundsException();
			}
			return (start == 0 && end == length) ? this : new LatinString15B(end, chars, chars2, start);
		}
	
	
		@Override
		public boolean equals (Object obj)
		{	
			/**
			 */
			if (this == obj)
			{
				return true;
			}
				
			if (obj == null)
			{
				return false;
			}
			
			if (getClass() == obj.getClass())
			{
				LatinString15 other = (LatinString15) obj;
				if (other.length != length)
				{
					return false;
				}
				return other.chars == chars && other.chars2 == chars2;
			}
			return equalsInternal(this, obj);
		}
	
	
		@Override
		public String toString ()
		{
			return toStringInternal(this);
		}
		
		
		/**
		 */
		private int hashCode = 0;
	
	
		@Override
		public int hashCode ()
		{
			if (hashCode != 0)
			{
				return hashCode;
			}
			hashCode = hashCodeInternal(this);
			return hashCode;
		}
	}

	/**
	 *
	 */
	private static final class LatinString0 implements LatinString
	{
	
		@Override
		public char charAt (int index)
		{
			throw new IndexOutOfBoundsException();
		}
	
	
		@Override
		public int length ()
		{
			return 0;
		}
	
	
		@Override
		public CharSequence subSequence (int start, int end)
		{
			if (start == 0 && end == 0)
			{
				return this;
			}
			throw new IndexOutOfBoundsException();
		}
	
	
		@Override
		public int hashCode ()
		{
			return 0;
		}
	
	
		@Override
		public boolean equals (Object obj)
		{
			if (this == obj)
			{
				return true;
			}
			
			if (obj == null)
			{
				return false;
			}
			
			if (getClass() == obj.getClass())
			{
				return true;
			}
			return equalsInternal(this, obj);
		}
	
	
		@Override
		public String toString ()
		{
			return toStringInternal(this);
		}
	}

	/**
	 * 
	 *
	 */
	private static final class LatinString2 implements LatinString
	{	
		/**
		 */
		private short chars;
	
		
		/**
		 * Constructor 
		 *
		 * @param seq CharSequence
		 */
		LatinString2 (CharSequence seq)
		{
			chars = (short) (((seq.charAt(0) - 0x20) & 0x3F) + (((seq.charAt(1) - 0x20) & 0x3F) << SHIFT[1]));
		}
	
	
		@Override
		public char charAt (int index)
		{
	
			if (index == 0)
			{
				return (char) (((chars) & 0x3F) + 0x20);
			}
	
			if (index == 1)
			{
				return (char) (((chars >> SHIFT[1]) & 0x3F) + 0x20);
			}
	
			throw new IndexOutOfBoundsException("" + index);
		}
	
	
		@Override
		public int length ()
		{
			return 2;
		}
	
	
		@Override
		public CharSequence subSequence (int start, int end)
		{
			if (start == 0)
			{
				if (end == 0)
				{
					return BLANK;
				}
				if (end == 1)
				{
					return createInstance(charAt(0));
				}
				if (end == 2)
				{
					return this;
				}
			}
			else if (start == 1)
			{
				if (end == 1)
				{
					return BLANK;
				}
				if (end == 2)
				{
					return createInstance(charAt(1));
				}
			}
			throw new IndexOutOfBoundsException();
		}
	
	
		@Override
		public boolean equals (Object obj)
		{
			if (this == obj)
			{
				return true;
			}
			
			if (obj == null)
			{
				return false;
			}
			
			if (getClass() == obj.getClass())
			{
				return ((LatinString2) obj).chars == chars;
			}
			return equalsInternal(this, obj);
		}
	
	
		@Override
		public String toString ()
		{
			return toStringInternal(this);
		}
	
	
		@Override
		public int hashCode ()
		{
			int hash = 0;
			hash = (((chars) & 0x3F) + 0x20);
			hash = (((chars >> SHIFT[1]) & 0x3F) + 0x20) + ((hash << 5) - hash);
			return hash;
		}
	}
	
	
	/**
	 * 
	 *
	 */
	private static final class LatinString5 implements LatinString
	{
		/**
		 */
		private int length;
	
		/**
		 */
		private int chars;
	
		
		/**
		 * Constructor 
		 *
		 * @param chars int
		 * @param length int
		 */
		LatinString5 (int chars, int length)
		{
			this.chars = chars & INT_MASK[length];
			this.length = length;
		}
	
		
		/**
		 * Constructor 
		 *
		 * @param seq CharSequence
		 * @param length int
		 */
		LatinString5 (CharSequence seq, int length)
		{
			this.length = length;
			chars = ((seq.charAt(0) - 0x20) & 0x3F) + (((seq.charAt(1) - 0x20) & 0x3F) << SHIFT[1]) + (((seq.charAt(2) - 0x20) & 0x3F) << SHIFT[2]);
			if (length > 3)
			{
				for (int i = 3; i < length; i++)
				{
					chars += (((seq.charAt(i) - 0x20) & 0x3F) << SHIFT[i]);
				}
			}
		}
	
	
		@Override
		public char charAt (int index)
		{
			if (index >= length)
			{
				throw new IndexOutOfBoundsException();
			}
			if (index < 0)
			{
				throw new IndexOutOfBoundsException();
			}
			return (char) (((chars >> SHIFT[index]) & 0x3F) + 0x20);
		}
	
	
		@Override
		public int length ()
		{
			return length;
		}
	
	
		@Override
		public CharSequence subSequence (int start, int end)
		{
			if (end > length || start < 0)
			{
				throw new IndexOutOfBoundsException();
			}
			if (start == 0 && end == length)
			{
				return this;
			}
			if (start == 0)
			{
				return new LatinString5(chars, end);
			}
			return new LatinString5B(end, chars, start);
		}
	
	
		@Override
		public boolean equals (Object obj)
		{
			if (this == obj)
			{
				return true;
			}
			
			if (obj == null)
			{
				return false;
			}
			
			if (getClass() == obj.getClass())
			{
				LatinString5 other = (LatinString5) obj;
				if (other.length != length)
				{
					return false;
				}
				return other.chars == chars;
			}
			return equalsInternal(this, obj);
		}
	
	
		@Override
		public String toString ()
		{
			return toStringInternal(this);
		}
		
		/**
		 */
		private int hashCode = 0;
	
	
		@Override
		public int hashCode ()
		{
			if (hashCode != 0)
			{
				return hashCode;
			}
			hashCode = hashCodeInternal(this);
			return hashCode;
		}
	}
	
	
	/**
	 * 
	 *
	 */
	private static final class LatinString5B implements LatinString
	{
		/**
		 */
		private int length;
	
		/**
		 */
		private int chars;
	
		/**
		 */
		private int offset;
	
		
		/**
		 * Constructor 
		 *
		 * @param length int
		 * @param chars int
		 * @param offset int
		 */
		private LatinString5B (int length, int chars, int offset)
		{
			super();
			this.length = length;
			this.chars = chars;
			this.offset = offset;
		}
	
	
		@Override
		public char charAt (int index)
		{
			index += offset;
			if (index >= length)
			{
				throw new IndexOutOfBoundsException();
			}
			if (index < 0)
			{
				throw new IndexOutOfBoundsException();
			}
			return (char) (((chars >> SHIFT[index]) & 0x3F) + 0x20);
		}
	
	
		@Override
		public int length ()
		{
			return length - offset;
		}
	
	
		@Override
		public CharSequence subSequence (int start, int end)
		{
			if (end > length - offset || start < 0)
			{
				throw new IndexOutOfBoundsException();
			}
	
			start += offset;
			end += offset;
	
			return (start == 0 && end == length) ? this : new LatinString5B(end, chars, start);
		}
	
	
		@Override
		public boolean equals (Object o)
		{
			return equalsInternal(this, o);
		}
	
	
		@Override
		public String toString ()
		{
			return toStringInternal(this);
		}
	
		
		/**
		 */
		private int hashCode = 0;
	
	
		@Override
		public int hashCode ()
		{
			if (hashCode != 0)
			{
				return hashCode;
			}
			hashCode = hashCodeInternal(this);
			return hashCode;
		}
	}
	
	
	/**
	 * 
	 *
	 */
	protected static final class LatinString10 implements LatinString
	{
		/**
		 */
		private int length;
	
		/**
		 */
		private long chars;
	
		
		/**
		 * Constructor 
		 *
		 * @param chars long
		 * @param length int
		 */
		LatinString10 (long chars, int length)
		{
			this.chars = chars & LONG_MASK[length];
			this.length = length;
		}
	
		
		/**
		 * Constructor 
		 *
		 * @param seq CharSequence
		 * @param length int
		 */
		LatinString10 (CharSequence seq, int length)
		{
			this.length = length;
			chars = ((seq.charAt(0) - 0x20) & 0x3F) + (((seq.charAt(1) - 0x20) & 0x3F) << SHIFT[1]) + (((seq.charAt(2) - 0x20) & 0x3F) << SHIFT[2]);
	
			for (int i = 3; i < length; i++)
			{
				chars += (((((long) seq.charAt(i)) - 0x20) & 0x3F) << SHIFT[i]);
			}
		}
	
	
		@Override
		public char charAt (int index)
		{
			if (index >= length)
			{
				throw new IndexOutOfBoundsException();
			}
			if (index < 0)
			{
				throw new IndexOutOfBoundsException();
			}
			return (char) (((chars >> SHIFT[index]) & 0x3F) + 0x20);
		}
	
	
		@Override
		public int length ()
		{
			return length;
		}
	
	
		@Override
		public CharSequence subSequence (int start, int end)
		{
			if (end > length || start < 0)
			{
				throw new IndexOutOfBoundsException();
			}
			return (start == 0 && end == length) ? this : new LatinString10B(end, chars, start);
		}
	
	
		@Override
		public boolean equals (Object obj)
		{
			if (this == obj)
			{
				return true;
			}
			
			if (obj == null)
			{
				return false;
			}
			
			if (getClass() == obj.getClass())
			{
				LatinString10 other = (LatinString10) obj;
				if (other.length != length)
				{
					return false;
				}
				return other.chars == chars;
			}
			return equalsInternal(this, obj);
		}
	
	
		@Override
		public String toString ()
		{
			return toStringInternal(this);
		}
	
		/**
		 */
		private int hashCode = 0;
	
	
		@Override
		public int hashCode ()
		{
			if (hashCode != 0)
			{
				return hashCode;
			}
			hashCode = hashCodeInternal(this);
			return hashCode;
		}
	}

	
	/**
	 * 
	 *
	 */
	private static final class LatinString10B implements LatinString
	{
		/**
		 */
		private int length; 
	
		/**
		 */
		private long chars;
	
		/**
		 */
		private int offset;
	
		
		/**
		 * Constructor 
		 *
		 * @param length int
		 * @param chars long
		 * @param offset int
		 */
		private LatinString10B (int length, long chars, int offset)
		{
			super();
			this.length = length;
			this.chars = chars;
			this.offset = offset;
		}
	
	
		@Override
		public char charAt (int index)
		{
			index += offset;
			if (index >= length)
			{
				throw new IndexOutOfBoundsException();
			}
			if (index < 0)
			{
				throw new IndexOutOfBoundsException();
			}
			return (char) (((chars >> SHIFT[index]) & 0x3F) + 0x20);
		}
	
	
		@Override
		public int length ()
		{
			return length - offset;
		}
	
	
		@Override
		public CharSequence subSequence (int start, int end)
		{
			if (end > length - offset || start < 0)
			{
				throw new IndexOutOfBoundsException();
			}
	
			start += offset;
			end += offset;
	
			return (start == 0 && end == length) ? this : new LatinString10B(end, chars, start);
		}
	
	
		@Override
		public boolean equals (Object o)
		{
			return equalsInternal(this, o);
		}
	
	
		@Override
		public String toString ()
		{
			return toStringInternal(this);
		}
		
		/**
		 */
		private int hashCode = 0;
	
	
		@Override
		public int hashCode ()
		{
			if (hashCode != 0)
			{
				return hashCode;
			}
			hashCode = hashCodeInternal(this);
			return hashCode;
		}
	}
	
	
	/**
	 * 
	 *
	 */
	private static final class LatinString15B implements LatinString
	{
		/**
		 */
		private int length;
	
		/**
		 */
		private long chars;
	
		/**
		 */
		private int chars2;
	
		/**
		 */
		private int offset;
	
		
		/**
		 * Constructor 
		 *
		 * @param length int
		 * @param chars long
		 * @param chars2 int
		 * @param offset int
		 */
		private LatinString15B (int length, long chars, int chars2, int offset)
		{
			super();
			this.length = length;
			this.chars = chars;
			this.chars2 = chars2;
			this.offset = offset;
		}
	
	
		@Override
		public char charAt (int index)
		{
			index += offset;
			if (index >= length)
			{
				throw new IndexOutOfBoundsException();
			}
			if (index < 0)
			{
				throw new IndexOutOfBoundsException();
			}
			if (index < MAX_64_BIT_LENGTH)
			{
				return (char) (((chars >> SHIFT[index]) & 0x3F) + 0x20);
			}
			return (char) (((chars2 >> SHIFT[index - MAX_64_BIT_LENGTH]) & 0x3F) + 0x20);
		}
	
	
		@Override
		public int length ()
		{
			return length - offset;
		}
	
	
		@Override
		public CharSequence subSequence (int start, int end)
		{
			if (end > length - offset || start < 0)
			{
				throw new IndexOutOfBoundsException();
			}
	
			start += offset;
			end += offset;
	
			return (start == 0 && end == length) ? this : new LatinString15B(end, chars, chars2, start);
		}
	
	
		@Override
		public boolean equals (Object o)
		{
			return equalsInternal(this, o);
		}
	
	
		@Override
		public String toString ()
		{
			return toStringInternal(this);
		}
	
		/**
		 */
		private int hashCode = 0;
	
	
		@Override
		public int hashCode ()
		{
			if (hashCode != 0)
			{
				return hashCode;
			}
			hashCode = hashCodeInternal(this);
			return hashCode;
		}
	}
	
	
	/**
	 */
	protected static final class LatinString20 implements LatinString
	{
		/**
		 */
		private int length;
	
		/**
		 */
		private long chars;
	
		/**
		 */
		private long chars2;
	
	
		/**
		 * Constructor 
		 *
		 * @param chars long
		 * @param chars2 long
		 * @param length int
		 */
		LatinString20 (long chars, long chars2, int length)
		{
			this.length = length;
			if (length <= MAX_64_BIT_LENGTH)
			{
				this.chars = chars & LONG_MASK[length];
				this.chars2 = 0;
			}
			else
			{
				this.chars = chars;
				this.chars2 = chars2 & LONG_MASK[length - MAX_64_BIT_LENGTH];
			}
		}
	
		
		/**
		 * Constructor 
		 *
		 * @param seq CharSequence
		 * @param length int
		 */
		LatinString20 (CharSequence seq, int length)
		{
			this.length = length;
			chars = ((seq.charAt(0) - 0x20) & 0x3F) + (((seq.charAt(1) - 0x20) & 0x3F) << SHIFT[1]) + (((seq.charAt(2) - 0x20) & 0x3F) << SHIFT[2]);
	
			for (int i = 3; i < MAX_64_BIT_LENGTH; i++)
			{
				chars += (((((long) seq.charAt(i)) - 0x20) & 0x3F) << SHIFT[i]);
			}
			for (int i = MAX_64_BIT_LENGTH; i < length; i++)
			{
				chars2 += (((((long) seq.charAt(i)) - 0x20) & 0x3F) << SHIFT[i - 10]);
			}
	
		}
	
	
		@Override
		public char charAt (int index)
		{
			if (index >= length)
			{
				throw new IndexOutOfBoundsException();
			}
			if (index < 0)
			{
				throw new IndexOutOfBoundsException();
			}
			if (index < MAX_64_BIT_LENGTH)
			{
				return (char) (((chars >> SHIFT[index]) & 0x3F) + 0x20);
			}
			return (char) (((chars2 >> SHIFT[index - MAX_64_BIT_LENGTH]) & 0x3F) + 0x20);
	
		}
	
	
		@Override
		public int length ()
		{
			return length;
		}
	
	
		@Override
		public CharSequence subSequence (int start, int end)
		{
			if (end > length || start < 0)
			{
				throw new IndexOutOfBoundsException();
			}
			return (start == 0 && end == length) ? this : new LatinString20B(end, chars, chars2, start);
		}
	
	
		@Override
		public boolean equals (Object obj)
		{
			if (this == obj)
			{
				return true;
			}
			
			if (obj == null)
			{
				return false;
			}
			
			if (getClass() == obj.getClass())
			{
				LatinString20 other = (LatinString20) obj;
				if (other.length != length)
				{
					return false;
				}
				return other.chars == chars && other.chars2 == chars2;
			}
			return equalsInternal(this, obj);
		}
	
	
		@Override
		public String toString ()
		{
			return toStringInternal(this);
		}
	
		/**
		 */
		private int hashCode = 0;
	
	
		@Override
		public int hashCode ()
		{
			if (hashCode != 0)
			{
				return hashCode;
			}
			hashCode = hashCodeInternal(this);
			return hashCode;
		}
	
	}
	
	
	/**
	 * 
	 *
	 */
	private static final class LatinString20B implements LatinString
	{
		/**
		 */
		private int length;
	
		/**
		 */
		private long chars;
	
		/**
		 */
		private long chars2;
	
		/**
		 */
		private int offset;
	
		/**
		 * Constructor 
		 *
		 * @param length int
		 * @param chars long
		 * @param chars2 long
		 * @param offset int
		 */
		private LatinString20B (int length, long chars, long chars2, int offset)
		{
			super();
			this.length = length;
			this.chars = chars;
			this.chars2 = chars2;
			this.offset = offset;
		}
	
	
		@Override
		public char charAt (int index)
		{
			index += offset;
			if (index >= length)
			{
				throw new IndexOutOfBoundsException();
			}
			if (index < 0)
			{
				throw new IndexOutOfBoundsException();
			}
			if (index < MAX_64_BIT_LENGTH)
			{
				return (char) (((chars >> SHIFT[index]) & 0x3F) + 0x20);
			}
			return (char) (((chars2 >> SHIFT[index - MAX_64_BIT_LENGTH]) & 0x3F) + 0x20);
		}
	
	
		@Override
		public int length ()
		{
			return length - offset;
		}
	
	
		@Override
		public CharSequence subSequence (int start, int end)
		{
			if (end > length - offset || start < 0)
			{
				throw new IndexOutOfBoundsException();
			}
	
			start += offset;
			end += offset;
	
			return (start == 0 && end == length) ? this : new LatinString20B(end, chars, chars2, start);
		}
	
	
		@Override
		public boolean equals (Object o)
		{
			return equalsInternal(this, o);
		}
	
	
		@Override
		public String toString ()
		{
			return toStringInternal(this);
		}
	
		/**
		 */
		private int hashCode = 0;
	
	
		@Override
		public int hashCode ()
		{
			if (hashCode != 0)
			{
				return hashCode;
			}
			hashCode = hashCodeInternal(this);
			return hashCode;
		}
	}
	
	
	/**
	 * 
	 *
	 */
	protected static final class LatinStringHuge implements LatinString
	{
		/**
		 */
		private int length;
	
		/**
		 */
		private long[] chars;
	
		/**
		 * Constructor 
		 *
		 * @param chars long[]
		 * @param length int
		 */
		LatinStringHuge (long[] chars, int length)
		{
			this.length = length;
			this.chars = chars;
		}
	
		
		/**
		 * Constructor 
		 *
		 * @param seq CharSequence
		 * @param length int
		 */
		LatinStringHuge (CharSequence seq, int length)
		{
			this.length = length;
			int size = (length - 1) / MAX_64_BIT_LENGTH + 1;
			this.chars = new long[size];
			for (int j = 0; j < size; j++)
			{
				int offset = MAX_64_BIT_LENGTH * j;
				int len = MAX_64_BIT_LENGTH;
				if (len + offset > length)
				{
					len = length - offset;
				}
				for (int i = 0; i < len; i++)
				{
					chars[j] += (((((long) seq.charAt(i + offset)) - 0x20) & 0x3F) << SHIFT[i]);
				}
			}
	
		}
	
	
		@Override
		public char charAt (int index)
		{
			if (index >= length)
			{
				throw new IndexOutOfBoundsException();
			}
			if (index < 0)
			{
				throw new IndexOutOfBoundsException();
			}
			int pos = index / MAX_64_BIT_LENGTH;
			return (char) (((chars[pos] >> SHIFT[index - MAX_64_BIT_LENGTH * pos]) & 0x3F) + 0x20);
		}
	
	
		@Override
		public int length ()
		{
			return length;
		}
	
	
		@Override
		public CharSequence subSequence (int start, int end)
		{
			if (end > length || start < 0)
			{
				throw new IndexOutOfBoundsException();
			}
			return (start == 0 && end == length) ? this : new LatinStringHugeB(end, chars, start);
		}
	
	
		@Override
		public boolean equals (Object obj)
		{
			if (this == obj)
			{
				return true;
			}
			
			if (obj == null)
			{
				return false;
			}
			
			if (getClass() == obj.getClass())
			{
				LatinStringHuge other = (LatinStringHuge) obj;
				if (other.length != length)
				{
					return false;
				}
				int size = (length - 1) / MAX_64_BIT_LENGTH;
				for (int i = 0; i < size; i++)
				{
					if (chars[i] != other.chars[i])
					{
						return false;
					}
				}
				return (chars[size] & LONG_MASK[length - size * MAX_64_BIT_LENGTH]) == (other.chars[size] & LONG_MASK[length - size * MAX_64_BIT_LENGTH]);
			}
			return equalsInternal(this, obj);
		}
	
	
		@Override
		public String toString ()
		{
			return toStringInternal(this);
		}
	
		/**
		 */
		private int hashCode = 0;
	
	
		@Override
		public int hashCode ()
		{
			if (hashCode != 0)
			{
				return hashCode;
			}
			hashCode = hashCodeInternal(this);
			return hashCode;
		}
	}
	
	
	/**
	 * 
	 *
	 */
	private static final class LatinStringHugeB implements LatinString
	{
		/**
		 */
		private int length;
	
		/**
		 */
		private long[] chars;
	
		/**
		 */
		private int offset;
	
		
		/**
		 * Constructor 
		 *
		 * @param length int
		 * @param chars long[]
		 * @param offset int
		 */
		LatinStringHugeB (int length, long[] chars, int offset)
		{
			this.offset = offset;
			this.length = length;
			this.chars = chars;
		}
	
	
		@Override
		public char charAt (int index)
		{
			index += offset;
			if (index >= length)
			{
				throw new IndexOutOfBoundsException();
			}
			if (index < 0)
			{
				throw new IndexOutOfBoundsException();
			}
			int pos = index / MAX_64_BIT_LENGTH;
			return (char) (((chars[pos] >> SHIFT[index - MAX_64_BIT_LENGTH * pos]) & 0x3F) + 0x20);
		}
	
	
		@Override
		public int length ()
		{
			return length - offset;
		}
	
	
		@Override
		public CharSequence subSequence (int start, int end)
		{
			if (end > length - offset || start < 0)
			{
				throw new IndexOutOfBoundsException();
			}
	
			start += offset;
			end += offset;
	
			return (start == 0 && end == length) ? this : new LatinStringHugeB(end, chars, start);
		}
	
	
		@Override
		public boolean equals (Object o)
		{
			return equalsInternal(this, o);
		}
	
	
		@Override
		public String toString ()
		{
			return toStringInternal(this);
		}
	
		
		/**
		 */
		private int hashCode = 0;
	
	
		@Override
		public int hashCode ()
		{
			if (hashCode != 0)
			{
				return hashCode;
			}
			hashCode = hashCodeInternal(this);
			return hashCode;
		}
	}


	/**
	 */
	static final LatinString BLANK = new LatinString0();

	/**
	 */
	static final int[] INT_MASK = { 0, 0x3F, 0xFFF, 0x3FFFF, 0xFFFFFF, 0x3FFFFFFF };

	/**
	 */
	public static final int LATIN_LETTER_MAX = 64;

	/**
	 */
	static final LatinString1[] LATIN_STRING_1 = new LatinString1[LATIN_LETTER_MAX];

	/**
	 */
	static final long[] LONG_MASK = { 0, 0x3F, 0xFFF, 0x3FFFF, 0xFFFFFF, 0x3FFFFFFF, 0xFFFFFFFFFL, 0x3FFFFFFFFFFL, 0xFFFFFFFFFFFFL, 0x3FFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFL };

	/**
	 */
	static final int[] SHIFT = { 0, 6, 12, 18, 24, 30, 36, 42, 48, 54, 60 };

	
	/**
	 */
	private static final String BLANK_STRING = "";

	/**
	 */
	private static final int MAX_64_BIT_LENGTH = 10;


	/**
	 * Creates an implementation of LatinString which represents the given
	 * CharSequence. All characters in the char sequence are made to latin upper
	 * case characters
	 * 
	 * @see CharSequenceUtil#toBasicLatinUpperCase(CharSequence)
	 * 
	 * @param seq the CharSequence
	 * @return the LatinString representation of the CharSequence
	 */
	public static LatinString createInstance (CharSequence seq)
	{
		if (seq == null)
		{
			return null;
		}

		if (seq instanceof LatinString)
		{
			return (LatinString) seq;
		}

		int length = seq.length();

		if (length == 0)
		{
			return BLANK;
		}

		CharSequence latin = CharSequenceUtil.toBasicLatinUpperCase(CharSequenceUtil.makeLatin(seq));

		if (length == 1)
		{
			return createInstance(latin.charAt(0));
		}

		if (length == 2)
		{
			return new LatinString2(latin);
		}
		if (length < 6)
		{
			return new LatinString5(latin, length);
		}
		if (length < 11)
		{
			return new LatinString10(latin, length);
		}
		if (length < 16)
		{
			return new LatinString15(latin, length);
		}
		if (length < 21)
		{
			return new LatinString20(latin, length);
		}
		return new LatinStringHuge(latin, length);
	}

	
	/**
	 * 
	 * @param ch char
	 * @return LatinString
	 */
	private static LatinString createInstance (char ch)
	{
		int intKey = ch - 0x0020;
		if (intKey > LATIN_LETTER_MAX)
		{
			throw new IllegalArgumentException("Character 0x" + Integer.toHexString(ch) + " is not basic latin upper case!");
		}
		if (LATIN_STRING_1[intKey] != null)
		{
			return LATIN_STRING_1[intKey];
		}

		LATIN_STRING_1[intKey] = new LatinString1(ch);
		return LATIN_STRING_1[intKey];
	}
	
	/**
	 * 
	 * @param seq CharSequence
	 * @return String
	 */
	private static String toStringInternal (CharSequence seq)
	{
		int len = seq.length();
		if (len == 0)
		{
			return BLANK_STRING;
		}
		StringBuilder bld = new StringBuilder(len);
		for (int i = 0; i < len; i++)
		{
			bld.append(seq.charAt(i));
		}
		return bld.toString();
	}

	
	/**
	 * 
	 * @param seq CharSequence
	 * @return  int
	 */
	private static int hashCodeInternal (CharSequence seq)
	{
		int hash = 0;
		int len = seq.length();
		for (int i = 0; i < len; i++)
		{
			hash = seq.charAt(i) + ((hash << 5) - hash);
		}
		return hash;
	}

	
	/**
	 * 
	 * @param seq CharSequence
	 * @param obj Object
	 * @return boolean boolean
	 */
	protected static boolean equalsInternal (CharSequence seq, Object obj)
	{
		try
		{
			final CharSequence other = (CharSequence) obj;
			int len = seq.length();
			if (other.length() != len)
			{
				return false;
			}
			for (int i = 0; i < len; i++)
			{
				if (seq.charAt(i) != other.charAt(i))
				{
					return false;
				}
			}
		}
		catch (ClassCastException e)
		{
			return false;
		}
		return true;
	}


	/**
	 */
	private HashSet<LatinString2> latinString2s = new HashSet<LatinString2>();

	
	/**
	 * Hidden Constructor 
	 *
	 */
	private LatinStringFactory ()
	{
		
	}
	
	
	/**
	 * 
	 * @return HashSet<LatinString2> 
	 */
	public HashSet<LatinString2> getLatinString2s ()
	{
		return this.latinString2s;
	}

}
