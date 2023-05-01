export interface Storage {
  save(key: string, value: string): void;
  load(key: string): string | null;
  delete(key: string): void;
}
