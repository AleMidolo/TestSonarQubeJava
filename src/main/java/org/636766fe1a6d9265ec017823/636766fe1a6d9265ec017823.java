import org.objectweb.asm.Symbol;
import org.objectweb.asm.Constants;

public class SymbolTable {
  private final Symbol[] symbols;
  private int size;

  public SymbolTable(int initialCapacity) {
  this.symbols = new Symbol[initialCapacity];
  this.size = 1;
  }

  public int addConstantNameAndType(final String name, final String descriptor) {
  int hashCode = Symbol.CONSTANT_NAME_AND_TYPE_TAG + name.hashCode() * descriptor.hashCode();
  
  // Check if symbol already exists
  Symbol symbol = lookupSymbol(hashCode, Constants.CONSTANT_NAME_AND_TYPE, name, descriptor);
  if (symbol != null) {
  return symbol.index;
  }
  
  // Add name and descriptor to constant pool if not already present
  int nameIndex = addConstantUtf8(name);
  int descriptorIndex = addConstantUtf8(descriptor);
  
  // Create and add new NameAndType symbol
  symbol = new Symbol(
  size++, 
  Constants.CONSTANT_NAME_AND_TYPE,
  nameIndex,
  descriptorIndex,
  hashCode
  );
  
  // Add to symbol table
  addSymbol(symbol);
  
  return symbol.index;
  }
  
  private Symbol lookupSymbol(int hashCode, int tag, String name, String descriptor) {
  for (Symbol symbol : symbols) {
  if (symbol != null && 
  symbol.tag == tag &&
  symbol.hashCode == hashCode &&
  symbol.owner.equals(name) && 
  symbol.value.equals(descriptor)) {
  return symbol;  
  }
  }
  return null;
  }
  
  private void addSymbol(Symbol symbol) {
  if (size >= symbols.length) {
  // Resize array if needed
  Symbol[] newSymbols = new Symbol[symbols.length * 2];
  System.arraycopy(symbols, 0, newSymbols, 0, symbols.length);
  symbols = newSymbols;
  }
  symbols[size - 1] = symbol;
  }
  
  private int addConstantUtf8(String value) {
  int hashCode = Symbol.CONSTANT_UTF8_TAG + value.hashCode();
  Symbol symbol = lookupSymbol(hashCode, Constants.CONSTANT_UTF8, value, null);
  if (symbol != null) {
  return symbol.index;
  }
  
  symbol = new Symbol(
  size++,
  Constants.CONSTANT_UTF8,
  value,
  null,
  hashCode
  );
  addSymbol(symbol);
  return symbol.index;
  }
}