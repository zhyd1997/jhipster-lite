import { Storage } from '@/common/domain/Storage';

export default class LocalStorage implements Storage {
  save(key: string, value: string): void {
    localStorage.setItem(key, value);
  }

  load(key: string): string | null {
    return localStorage.getItem(key);
  }

  /* istanbul ignore next */
  delete(key: string): void {
    localStorage.removeItem(key);
  }
}
